package com.example.tutometeo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Ce tuto traite l'utilisation des fragments sous ANDROID. Pour d'avantage
 * d'informations : f.ferjani.farouk@gmail.com
 * 
 * @author Farouk FERJANI
 * 
 */
public class ListPaysFragment extends Fragment {
	/**
	 * Pour l'exemple nous nous contenterons d'une liste de trois �l�ments.
	 */
	String[] pays = new String[] { "Tunis", "La Marsa", "Sidi Bou Said" };
	/**
	 * Permet au fragment de communiquer avec la classe qui l'h�berge.
	 */
	private OnPaysSelected paysFragListener;

	/**
	 * Cette interface permet de faire appel � des m�thodes �crites au niveau de
	 * la classe de l'activit�. Pour le faire nous devons �crire les signatures
	 * des m�thodes auxquelles nous souhaiterons faire appel � partir de ce
	 * fragment. Dans notre cas, nous souhaiterons faire appel � la m�thode
	 * paysSelect(String name) qui se chargera de d�marrer une activit� si
	 * l'application tourne sur un smartphone ou de mettre � jour un fragment
	 * existant � l'�cran dans le cas d'une tablette.
	 */
	public interface OnPaysSelected {
		/**
		 * @param name
		 *            Nom du pays s�lectionn� sur la liste.
		 */
		public void paysSelect(String name);
	}

	/**
	 * Appel�e lorsque le fragment vient d'�tre attach� � une activit�. 
	 * NB : Appel� uniquement pour le premier fragment.
	 * */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			paysFragListener = (OnPaysSelected) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " doit implementer OnPaysSelected ");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// On commence par charger le contenu du fichier list_pays_fragment.xml
		// dans le fragment.
		final View view = inflater.inflate(R.layout.list_pays_fragment,
				container, false);
		ListView listPays = (ListView) view.findViewById(R.id.list_pays);

		listPays.setAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, pays));
		listPays.setOnItemClickListener(selectPays);
		return view;
	}

	private OnItemClickListener selectPays = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// On informe l'activit� qu'il y a clic sur le pays dont le nom est
			// pays[arg2]
			paysFragListener.paysSelect(pays[arg2]);
		}
	};
}
