import java.util.Scanner;
import java.util.Stack;

public class 4949 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // 입력받은 문자열 변수
        String sentence;

        while (true){
            // 문자열 입력받음
            sentence = s.nextLine();

            // .이 입력되면 입력 받는 걸 종료
            if(sentence.equals(".")){
                break;
            }

            System.out.println(test(sentence));
        }
    }


    // 조건을 판단해주는 함수
    public static String test(String sentenceInput){
        String sentence = sentenceInput;

        // 임시 변수
        char c;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < sentence.length(); i++) {
            // cahrAt: 문자열을 문자로
            c = sentence.charAt(i);

            if(c == '(' || c =='['){
                stack.push(c);
            } else if (c == ']'){
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                } else {
                    return "no";
                }
            } else if (c == ')') {
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                } else {
                    return "no";
                }
            }
        }

        // 스택이 비어있는지를 통해 해당 문자열의 균형 파악
        if(!stack.isEmpty()){
            return "no";
        } else{
            return "yes";
        }

    }

}
