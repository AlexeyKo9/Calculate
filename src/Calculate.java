import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "*", "/"};
        String[] regexActions = {"\\+", "-", "\\*", "/"};
        Scanner snc = new Scanner(System.in);
        System.out.println("Введи выражение: ");
        String exp = snc.nextLine();
        int actionIndex=-1;
        for (int i=0; i<actions.length; i++) {
            if(exp.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        if (actionIndex==-1){
            System.out.println("Некорректное выражение");
            return;
        }

        String[] data = exp.split(regexActions[actionIndex]);
        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
            int a,b;
            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman){
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            }else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }

          if (a>0 & a<11 & b>0 & b<11) {

            int f = 0;
            switch (actions[actionIndex]){
                case "+":
                     f = a+b;
                     break;
                case "-":
                    f = a-b;
                    break;
                case "*":
                    f = a*b;
                    break;
                case "/":
                    f = a/b;
                    break;
            }
            if (isRoman){
                System.out.println(converter.intToRoman(f));
            }
            else {
                System.out.println(f);
            }
          }else {
              System.out.println("Должны быть числа от 1 до 10");
          }
        }else {
            System.out.println("Числа должны быть в одном формате");
        }
    }
}

