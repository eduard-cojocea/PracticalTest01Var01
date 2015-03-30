package ro.pub.cs.systems.pdsd.practicaltest01var01;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;


public class PracticalTest01Var01MainActivity extends ActionBarActivity {

    protected EditText text;
    protected CheckBox phone, email, mess;
    protected int count;
    protected boolean phoneIsChecked, emailIsChecked, messIsChecked;

    private CheckBoxCheckListener checkListener = new CheckBoxCheckListener();

    private class CheckBoxCheckListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if(isChecked){
                        count++;
                    }
                    else{
                        count--;
                    }

            /*count = 0;
            if(phone.isChecked()){
                count++;
            }
            if(email.isChecked()){
                count++;
            }
            if(mess.isChecked()){
                count++;
            }*/
            text.setText(String.valueOf(count));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        count = 0;
        phoneIsChecked = false;
        emailIsChecked = false;
        messIsChecked = false;

        text = (EditText)findViewById(R.id.editText);

        phone = (CheckBox)findViewById(R.id.phoneCheckBox);
        email = (CheckBox)findViewById(R.id.emailCheckBox);
        mess = (CheckBox)findViewById(R.id.instantMessagingCheckBox);

        phone.setOnCheckedChangeListener(checkListener);
        email.setOnCheckedChangeListener(checkListener);
        mess.setOnCheckedChangeListener(checkListener);

        text.setText(String.valueOf(0));

        if (savedInstanceState != null) {
            phoneIsChecked = savedInstanceState.getBoolean("phone");
            //if (phoneIsChecked) {
                phone.setChecked(phoneIsChecked);
            /*} else {
                phone.setChecked(false);
            }*/

            emailIsChecked = savedInstanceState.getBoolean("email");
           // if (emailIsChecked) {
                email.setChecked(emailIsChecked);
            /*} else {
                email.setChecked(false);
            }*/

            messIsChecked = savedInstanceState.getBoolean("mess");
            //if (messIsChecked) {
                mess.setChecked(messIsChecked);
            /*} else {
                mess.setChecked(false);
            }*/
        } else {
            phone.setChecked(false);
            email.setChecked(false);
            mess.setChecked(false);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        CheckBox p = (CheckBox)findViewById(R.id.phoneCheckBox);
        CheckBox e = (CheckBox)findViewById(R.id.phoneCheckBox);
        CheckBox m = (CheckBox)findViewById(R.id.phoneCheckBox);
        savedInstanceState.putBoolean("phone", p.isChecked());
        savedInstanceState.putBoolean("email", e.isChecked());
        savedInstanceState.putBoolean("mess", m.isChecked());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test01_var01_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
