package presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import data.UserRepositoryImpl;
import domain.LoadUserUseCase;
import domain.SaveUserUseCase;
import domain.entety.User;
import ru.gb.clear_architecture_test.R;

public class MainActivity extends AppCompatActivity {

    Button btnSave, btnLoad;
    EditText editFirst, editSecond;

    private LoadUserUseCase loadUserUseCase;
    private SaveUserUseCase saveUserUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        btnLoad=findViewById(R.id.btn_load);
        btnSave=findViewById(R.id.btn_save);
        editFirst=findViewById(R.id.first_edit_text);
        editSecond=findViewById(R.id.second_edit_text);

        loadUserUseCase = new LoadUserUseCase(new UserRepositoryImpl(this));
        saveUserUseCase = new SaveUserUseCase(new UserRepositoryImpl(this));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editSecond.getText().toString();
                User user = new User(name);
                boolean success = saveUserUseCase.saveUser(user);
                if(success){
                    editFirst.setText("Данные успешно сохранены");
                    editSecond.getText();
                }
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=loadUserUseCase.loadUser();
                editFirst.setText(name);
            }
        });
    }


}