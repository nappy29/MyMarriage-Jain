package com.example.root.mymarriage_jain;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by root on 6/26/17.
 */

public class SignupActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText fname, mname, lname, ffname, fmname, flname, bplace, add1, add2, email, phone,
            cast, subcast, profession, salary, padd1, padd2,pphone, rfname, rmname, rlname, radd1, radd2, remail, rphone, pin, pass, cpass;

    private TextInputLayout input_layout_fname,input_layout_mname,input_layout_lname, input_layout_birthplace,
            input_layout_useremail,input_layout_userphone,input_layout_cast, input_layout_subcast, input_layout_prof,
            input_layout_salary,input_layout_pin, input_layout_ffname, input_layout_fmname, input_layout_flname, input_layout_add2,
            input_layout_add1,input_layout_pphone,input_layout_padd1,input_layout_padd2,input_layout_rfname,input_layout_rmname,
            input_layout_rlname,input_layout_radd1, input_layout_radd2,input_layout_remail,input_layout_rphone,input_layout_cpass,
            input_layout_pass;

    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    DatePickerDialog.OnDateSetListener date;

    Button date_btn, time_btn;

    Spinner acc_by, marita_status, gender;
    String acctitle = "Self", marital_tit = "Never Married", gender_tit = "Male";
    ImageButton image_user;
    Toolbar toolbar;
    @Override public void onCreate(Bundle saved){
        super.onCreate(saved);

        setContentView(R.layout.signup_activity);

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Register new Account");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        fname = (EditText)findViewById(R.id.input_fname);
        mname = (EditText)findViewById(R.id.input_mname);
        lname = (EditText)findViewById(R.id.input_lname);
        ffname = (EditText)findViewById(R.id.input_ffname);
        flname = (EditText)findViewById(R.id.input_fmname);
        fmname = (EditText)findViewById(R.id.input_flname);
        bplace = (EditText)findViewById(R.id.input_birthplace);
        add1 = (EditText)findViewById(R.id.input_add1);
        add2 = (EditText)findViewById(R.id.input_add2);
        email = (EditText)findViewById(R.id.input_useremail);
        phone = (EditText)findViewById(R.id.input_userphone);
        cast = (EditText)findViewById(R.id.input_cast);
        subcast = (EditText)findViewById(R.id.input_subcast);
        profession = (EditText)findViewById(R.id.input_prof);
        salary = (EditText)findViewById(R.id.input_salary);
        padd1 = (EditText)findViewById(R.id.input_padd1);
        padd2 = (EditText)findViewById(R.id.input_padd2);
        pphone = (EditText)findViewById(R.id.input_pphone);
        rfname = (EditText)findViewById(R.id.input_rfname);
        rmname = (EditText)findViewById(R.id.input_rmname);
        rlname = (EditText)findViewById(R.id.input_rlname);
        radd1 = (EditText)findViewById(R.id.input_radd1);
        radd2 = (EditText)findViewById(R.id.input_radd2);
        remail = (EditText)findViewById(R.id.input_remail);
        rphone = (EditText)findViewById(R.id.input_rphone);
        pin = (EditText)findViewById(R.id.input_pin);
        pass = (EditText)findViewById(R.id.input_pass);
        cpass = (EditText)findViewById(R.id.input_cpass);


        input_layout_fname = (TextInputLayout) findViewById(R.id. input_layout_fname);
        input_layout_mname = (TextInputLayout) findViewById(R.id. input_layout_mname);
        input_layout_lname = (TextInputLayout) findViewById(R.id. input_layout_lname);
        input_layout_birthplace = (TextInputLayout) findViewById(R.id.input_layout_birthplace);
        input_layout_useremail = (TextInputLayout) findViewById(R.id.input_layout_useremail);
        input_layout_userphone = (TextInputLayout) findViewById(R.id.input_layout_userphone);
        input_layout_cast = (TextInputLayout) findViewById(R.id.input_layout_cast);
        input_layout_subcast = (TextInputLayout) findViewById(R.id.input_layout_subcast);
        input_layout_prof = (TextInputLayout) findViewById(R.id.input_layout_prof);
        input_layout_salary = (TextInputLayout) findViewById(R.id.input_layout_salary);
        input_layout_pin = (TextInputLayout) findViewById(R.id.input_layout_pin);
        input_layout_ffname = (TextInputLayout) findViewById(R.id.input_layout_ffname);
        input_layout_fmname = (TextInputLayout) findViewById(R.id.input_layout_fmname);
        input_layout_flname = (TextInputLayout) findViewById(R.id.input_layout_flname);
        input_layout_add1 = (TextInputLayout) findViewById(R.id.input_layout_add1);
        input_layout_add2 = (TextInputLayout) findViewById(R.id.input_layout_add2);
        input_layout_pphone = (TextInputLayout) findViewById(R.id.input_layout_pphone);
        input_layout_padd1 = (TextInputLayout) findViewById(R.id.input_layout_padd1);
        input_layout_padd2 = (TextInputLayout) findViewById(R.id.input_layout_padd2);
        input_layout_rfname = (TextInputLayout) findViewById(R.id.input_layout_rfname);
        input_layout_rmname = (TextInputLayout) findViewById(R.id.input_layout_rmname);
        input_layout_rlname = (TextInputLayout) findViewById(R.id.input_layout_rlname);
        input_layout_radd1 = (TextInputLayout) findViewById(R.id.input_layout_radd1);
        input_layout_radd2 = (TextInputLayout) findViewById(R.id.input_layout_radd2);
        input_layout_remail = (TextInputLayout) findViewById(R.id.input_layout_remail);
        input_layout_rphone = (TextInputLayout) findViewById(R.id.input_layout_rphone);
        input_layout_pass = (TextInputLayout) findViewById(R.id.input_layout_pass);
        input_layout_cpass = (TextInputLayout) findViewById(R.id.input_layout_cpass);

        fname.addTextChangedListener(new MyTextWatcher(fname));
        mname.addTextChangedListener(new MyTextWatcher(mname));
        lname.addTextChangedListener(new MyTextWatcher(lname));
        ffname.addTextChangedListener(new MyTextWatcher(ffname));
        fmname.addTextChangedListener(new MyTextWatcher(fmname));
        flname.addTextChangedListener(new MyTextWatcher(flname));
        bplace.addTextChangedListener(new MyTextWatcher(bplace));
        add1.addTextChangedListener(new MyTextWatcher(add1));
        add2.addTextChangedListener(new MyTextWatcher(add2));
        email.addTextChangedListener(new MyTextWatcher(email));
        phone.addTextChangedListener(new MyTextWatcher(phone));
        cast.addTextChangedListener(new MyTextWatcher(cast));
        subcast.addTextChangedListener(new MyTextWatcher(subcast));
        profession.addTextChangedListener(new MyTextWatcher(profession));
        salary.addTextChangedListener(new MyTextWatcher(salary));
        padd1.addTextChangedListener(new MyTextWatcher(padd1));
        padd2.addTextChangedListener(new MyTextWatcher(padd2));
        pphone.addTextChangedListener(new MyTextWatcher(pphone));
        rfname.addTextChangedListener(new MyTextWatcher(rfname));
        rmname.addTextChangedListener(new MyTextWatcher(rmname));
        rlname.addTextChangedListener(new MyTextWatcher(rlname));
        radd1.addTextChangedListener(new MyTextWatcher(radd1));
        radd2.addTextChangedListener(new MyTextWatcher(radd2));
        remail.addTextChangedListener(new MyTextWatcher(remail));
        rphone.addTextChangedListener(new MyTextWatcher(rphone));
        pin.addTextChangedListener(new MyTextWatcher(pin));
        pass.addTextChangedListener(new MyTextWatcher(pass));
        cpass.addTextChangedListener(new MyTextWatcher(cpass));


        date_btn = (Button) findViewById(R.id.date_btn);
        time_btn = (Button) findViewById(R.id.time_btn);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        acc_by = (Spinner) findViewById(R.id.acc_by);
        marita_status = (Spinner) findViewById(R.id.status);
        gender = (Spinner) findViewById(R.id.gender);

        acc_by.setOnItemSelectedListener(SignupActivity.this);
        marita_status.setOnItemSelectedListener(SignupActivity.this);
        gender.setOnItemSelectedListener(SignupActivity.this);

         date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.signup_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.save_submit) {
            if(isFormValid()){
                Snackbar.make(findViewById(android.R.id.content), "All text fields behave well. smile", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

            else
                Snackbar.make(findViewById(android.R.id.content), "Make sure all fields are inputted correctly ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean validatePhone() {
        String number = phone.toString().trim();

        if(number.isEmpty() || !isValidNumber(number)){
            input_layout_userphone.setError("Please provide correct indian number");
            requestFocus(this.phone);
            return false;
        }

        else
            input_layout_userphone.setErrorEnabled(false);

        return true;
    }

    private boolean validateEmail() {
        String email = this.email.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            input_layout_useremail.setError("Enter valid email address");
            requestFocus(this.email);
            return false;
        } else {
            input_layout_useremail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateFname() {
        String name = this.fname.getText().toString().trim();

        if (name.isEmpty() || name.length() < 3 ) {
            input_layout_fname.setError("Name must be of lenght greater than 3");
            requestFocus(this.fname);
            return false;
        } else {
            input_layout_fname.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateMname() {
        String name = this.mname.getText().toString().trim();

        if (name.isEmpty() || name.length() < 3 ) {
            input_layout_mname.setError("Name must be of lenght greater than 3");
            requestFocus(this.mname);
            return false;
        } else {
            input_layout_mname.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateLname() {
        String name = this.lname.getText().toString().trim();

        if (name.isEmpty() || name.length() < 3 ) {
            input_layout_lname.setError("Name must be of lenght greater than 3");
            requestFocus(this.lname);
            return false;
        } else {
            input_layout_lname.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateFfname() {
        String name = this.ffname.getText().toString().trim();

        if (name.isEmpty() || name.length() < 3 ) {
            input_layout_ffname.setError("Name must be of lenght greater than 3");
            requestFocus(this.ffname);
            return false;
        } else {
            input_layout_ffname.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateFmname() {
        String name = this.fmname.getText().toString().trim();

        if (name.isEmpty() || name.length() < 3 ) {
            input_layout_fmname.setError("Name must be of lenght greater than 3");
            requestFocus(this.fmname);
            return false;
        } else {
            input_layout_fmname.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateFlname() {
        String name = this.flname.getText().toString().trim();

        if (name.isEmpty() || name.length() < 3 ) {
            input_layout_flname.setError("Name must be of lenght greater than 3");
            requestFocus(this.flname);
            return false;
        } else {
            input_layout_flname.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateBplace() {
        String name = this.bplace.getText().toString().trim();

        if (name.isEmpty() || name.length() < 3 ) {
            input_layout_birthplace.setError("This fill cannot be left out");
            requestFocus(this.bplace);
            return false;
        } else {
            input_layout_birthplace.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateAdd1() {
        String name = this.add1.getText().toString().trim();

        if (name.isEmpty() ) {
            input_layout_add1.setError("Please provide a city");
            requestFocus(this.add1);
            return false;
        } else {
            input_layout_add1.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateAdd2() {
        String name = this.add2.getText().toString().trim();

        if (name.isEmpty() ) {
            input_layout_add2.setError("Please provide a state address");
            requestFocus(this.add1);
            return false;
        } else {
            input_layout_add2.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatecast() {
        String name = this.cast.getText().toString().trim();

        if (name.isEmpty() || name.length() < 3 ) {
            input_layout_cast.setError("Please provide your cast");
            requestFocus(this.cast);
            return false;
        } else {
            input_layout_cast.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatesubcast() {
        String name = this.subcast.getText().toString().trim();

        if (name.isEmpty() || name.length() < 3 ) {
            input_layout_subcast.setError("Please provide your subcast");
            requestFocus(this.subcast);
            return false;
        } else {
            input_layout_subcast.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateProfession() {
        String name = this.profession.getText().toString().trim();

        if (name.isEmpty()) {
            input_layout_prof.setError("please enter your profession");
            requestFocus(this.profession);
            return false;
        } else {
            input_layout_prof.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateSalary() {
        String name = this.salary.getText().toString().trim();

        if (name.isEmpty() ) {
            input_layout_salary.setError("Please enter your salary info");
            requestFocus(this.add1);
            return false;
        } else {
            input_layout_add1.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePadd1() {
        String name = this.padd1.getText().toString().trim();

        if (name.isEmpty() || name.length() < 3 ) {
            input_layout_padd1.setError("Please enter parents' city address");
            requestFocus(this.padd1);
            return false;
        } else {
            input_layout_padd1.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePadd2() {
        String name = this.add1.getText().toString().trim();

        if (name.isEmpty()) {
            input_layout_padd1.setError("Please enter parents' state address");
            requestFocus(this.add1);
            return false;
        } else {
            input_layout_add1.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePphone() {
        String number = pphone.getText().toString().trim();

        if(number.isEmpty() || !isValidNumber(number)){
            input_layout_pphone.setError("Please provide correct indian number");
            requestFocus(this.pphone);
            return false;
        }

        else
            input_layout_pphone.setErrorEnabled(false);

        return true;
    }

    private boolean validateRfname() {
        String name = this.rfname.getText().toString().trim();

        if (name.isEmpty()) {
            input_layout_rfname.setError("Please enter Relative's name");
            requestFocus(this.rfname);
            return false;
        } else {
            input_layout_rfname.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateRmname() {
        String name = this.rfname.getText().toString().trim();

        if (name.isEmpty()) {
            input_layout_rmname.setError("Please enter Relative's name");
            requestFocus(this.rmname);
            return false;
        } else {
            input_layout_rlname.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateRlname() {
        String name = this.rlname.getText().toString().trim();

        if (name.isEmpty()) {
            input_layout_rlname.setError("Please enter Relative's name");
            requestFocus(this.rlname);
            return false;
        } else {
            input_layout_rlname.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateRadd1() {
        String name = this.radd1.getText().toString().trim();

        if (name.isEmpty()) {
            input_layout_radd1.setError("Please enter Relative's city address");
            requestFocus(this.radd1);
            return false;
        } else {
            input_layout_radd1.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateRadd2() {
        String name = this.radd1.getText().toString().trim();

        if (name.isEmpty()) {
            input_layout_radd2.setError("Please enter Relative's state address");
            requestFocus(this.radd2);
            return false;
        } else {
            input_layout_radd2.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateRphone() {
        String number = rphone.getText().toString().trim();

        if(number.isEmpty() || !isValidNumber(number)){
            input_layout_rphone.setError("Please provide correct indian number");
            requestFocus(this.rphone);
            return false;
        }

        else
            input_layout_rphone.setErrorEnabled(false);

        return true;
    }

    private boolean validateRemail() {
        String email = this.remail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            input_layout_remail.setError("Enter valid email address");
            requestFocus(this.remail);
            return false;
        } else {
            input_layout_remail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePin() {
        String name = this.pin.getText().toString().trim();

        if (name.isEmpty() || name.length() != 6 ) {
            input_layout_pin.setError("Please enter a valid pin");
            requestFocus(this.pin);
            return false;
        } else {
            input_layout_pin.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePass() {
        if (pass.getText().toString().isEmpty() || pass.getText().toString().length() <= 6) {
            input_layout_pass.setError("Password should be atleast 7 characters long");
            requestFocus(pass);
            return false;
        } else {
            input_layout_pass.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateCpass() {
        if (cpass.getText().toString().isEmpty() || !cpass.getText().toString().equals(pass.getText().toString())) {
            input_layout_cpass.setError("Passwords don't match");
            requestFocus(cpass);
            return false;
        } else {
            input_layout_cpass.setErrorEnabled(false);
        }

        return true;
    }


    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private static boolean isValidNumber(String phone){
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()){
            case R.id.acc_by:
                acctitle = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), acctitle, Toast.LENGTH_LONG).show();
                break;

            case R.id.status:
                marital_tit = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), marital_tit, Toast.LENGTH_LONG).show();
                break;

            case R.id.gender:
                gender_tit = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), gender_tit, Toast.LENGTH_LONG).show();
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_useremail:
                    validateEmail();
                    break;
                case R.id.input_pass:
                    validatePass();
                    break;

                case R.id.input_cpass:
                    validateCpass();
                    break;

                case R.id.input_userphone:
                    validatePhone();
                    break;

                case R.id.input_fname:
                    validateFname();
                    break;

                case R.id.input_mname:
                    validateMname();
                    break;

                case R.id.input_lname:
                    validateLname();
                    break;

                case R.id.input_ffname:
                    validateFfname();
                    break;

                case R.id.input_fmname:
                    validateFname();
                    break;

                case R.id.input_flname:
                    validateFlname();
                    break;

                case R.id.input_birthplace:
                    validateBplace();
                    break;

                case R.id.input_add1:
                    validateAdd1();
                    break;

                case R.id.input_add2:
                    validateAdd2();
                    break;

                case R.id.input_cast:
                    validatecast();
                    break;

                case R.id.input_subcast:
                    validatesubcast();
                    break;

                case R.id.input_prof:
                    validateProfession();
                    break;

                case R.id.input_salary:
                    validateSalary();
                    break;

                case R.id.input_padd1:
                    validatePadd1();
                    break;

                case R.id.input_padd2:
                    validatePadd2();
                    break;

                case R.id.input_pphone:
                    validatePphone();
                    break;

                case R.id.input_rfname:
                    validateRfname();
                    break;

                case R.id.input_rmname:
                    validateRmname();
                    break;

                case R.id.input_rlname:
                    validateRlname();
                    break;

                case R.id.input_radd1:
                    validateRadd1();
                    break;

                case R.id.input_radd2:
                    validateRadd2();
                    break;

                case R.id.input_remail:
                    validateRemail();
                    break;

                case R.id.input_rphone:
                    validateRphone();
                    break;

                case R.id.input_pin:
                    validatePin();
                    break;

            }
        }
    }

    public boolean isFormValid(){
        if(validateFname() && validateMname() && validateLname() && validateFfname() && validateFmname() && validateFlname()
           && validateBplace() && validateAdd1() & validateAdd2() && validateEmail() && validatePhone() && validatecast()
           && validatesubcast() && validatePhone() && validateSalary() && validatePadd1() && validatePadd2() && validatePphone()
           && validateRfname() && validateRmname() && validateRlname() && validateRadd1() && validateRadd2() && validateRemail()
           && validateRphone() && validatePin() && validatePass() && validateCpass())

            return true;

        else return false;
    }

    public void setDate(View v){

        Calendar maxDate = Calendar.getInstance();
        maxDate.set(Calendar.YEAR, 1997);

        DatePickerDialog datePicker1 = new DatePickerDialog(SignupActivity.this, date, calendar
                .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));

        datePicker1.getDatePicker().setMaxDate(maxDate.getTimeInMillis());

        datePicker1.show();
    }

    public void setTime(View v){
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(SignupActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                time_btn.setText( selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select BirthTime");
        mTimePicker.show();

    }

    private void updateLabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        date_btn.setText(sdf.format(calendar.getTime()));
    }
}
