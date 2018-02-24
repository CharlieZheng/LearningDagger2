package com.jp.mydaggerdemo2.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jp.mydaggerdemo.R;

import javax.inject.Inject;

import com.jp.mydaggerdemo2.component.DaggerMainActivityComponent;
import com.jp.mydaggerdemo2.entity.Person;

public class MainActivity extends AppCompatActivity {
	private Button btn;
	@Inject
	public Person person;
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DaggerMainActivityComponent.builder().createbuild().create(this);
		setContentView(R.layout.main);
		btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (person == null) {

				Toast.makeText(MainActivity.this,"null", Toast.LENGTH_LONG ).show();
				}else {
					Toast.makeText(MainActivity.this, person.name, Toast.LENGTH_LONG).show();
				}
			}
		});
 }
}
