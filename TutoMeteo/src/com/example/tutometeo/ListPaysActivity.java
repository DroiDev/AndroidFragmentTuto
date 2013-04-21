package com.example.tutometeo;

import com.example.tutometeo.ListPaysFragment.OnPaysSelected;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Ce tuto traite l'utilisation des fragments sous ANDROID. Pour d'avantage
 * d'informations : f.ferjani.farouk@gmail.com
 * 
 * @author Farouk FERJANI
 * 
 */
public class ListPaysActivity extends FragmentActivity implements
		OnPaysSelected {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_pays);
	}

	public void paysSelect(String region) {
		//On r�cup�re le fragment PrevisionFragment
		PrevisionFragment fragment = (PrevisionFragment) getSupportFragmentManager()
				.findFragmentById(R.id.prevision_fragment);
		//Si le fragment est d�j� � l'�cran on le met � jour (tablette), si non on d�marre une nouvelle activit� (Smartphone). 
		if ((fragment != null) && fragment.isInLayout()) {
			fragment.setMsg("Pr�vision de " + region
					+ " dans un fragment mis � jour");
		} else {
			Intent intent = new Intent(this, PrevisionActivity.class);
			intent.putExtra(PrevisionActivity.MSG_EXTRAS, "Pr�vision de "
					+ region + " dans une nouvelle activit�");
			startActivity(intent);
		}
	}

}
