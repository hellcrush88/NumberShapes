package sky.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.N;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text =(TextView)findViewById(R.id.textView3);
        text.setSelected(true);
        Animation marquee = AnimationUtils.loadAnimation(this, R.anim.marquee);
        //text.setAnimation(marquee);
    }

    public void testNumber(View view){
        EditText numberText = (EditText)findViewById(R.id.editText);



        if(numberText.getText().toString().isEmpty()){
            makeToast("Please enter a number");
        }else{
            Number num = new Number();
            num.number = Integer.parseInt(numberText.getText().toString());
            if(num.isSquareNumber()){
                if(num.isTriangularNumber()){
                    makeToast("It is both square and triangular number!!");
                }else{
                    makeToast("It is a square number");
                }
            }else{
                if(num.isTriangularNumber()){
                    makeToast("It is a triangular number");
                }else{
                    makeToast("is neither square nor triangular");
                }
            }
        }
    }

    class Number{

        int number;

        public boolean isSquareNumber(){
            double squareRoot = Math.sqrt(number);
            if(squareRoot == Math.floor(squareRoot)){
                return true;
            }else{
                return false;
            }
        }

        public boolean isTriangularNumber(){
            int x = 1;
            int triangularNumber = 1;
            while(triangularNumber < number){
                x++;
                triangularNumber = triangularNumber + x;
            }
            if(triangularNumber == number){
                return true;
            }else{
                return false;
            }
        }
    }

    public void makeToast(String string){
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }
}
