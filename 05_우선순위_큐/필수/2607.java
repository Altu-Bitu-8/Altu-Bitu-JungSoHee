import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 기준 단어의 구성요소(알파벳)에 대해 카운트를 한다.
// A: 65 => 알파벳 개수: 26개
// 비교해야 하는 단어의 구성요소를 카운트 된 값과 비교하며 같은 구성을 만족하는지 확인한다.
public class 2607 {
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];

        int resultCount = 0;

        // 기준 문자열 입력
        String firstWord = br.readLine();

        // 기준 단어에 대한 알파벳 요소 카운트
        for (int k = 0; k < firstWord.length(); k++) {
        alphabet[firstWord.charAt(k)-'A']++;
        }


        // 문자열 입력 (첫번째 기준 문자열은 입력 받았으니까 N-1)
        for (int i = 0; i < N-1; i++) {
        int cntWord = 0;
        String nwords = br.readLine();

        int[] tempAlphabet = alphabet.clone();

        // 2이상 차이나면 바로 다음 단어
        if (nwords.length()-1 > firstWord.length() || nwords.length()+1 < firstWord.length()){
        continue;
        }

        for (int j = 0; j < nwords.length(); j++) {
        if (tempAlphabet[nwords.charAt(j)-'A'] > 0){
        cntWord++;
        tempAlphabet[nwords.charAt(j)-'A']--;
        }
        }

        // 비교
        if (nwords.length() == firstWord.length() && (cntWord == firstWord.length() || cntWord == firstWord.length()-1)){
        resultCount++;

        } else if(nwords.length() > firstWord.length() && cntWord == firstWord.length()){
        // firstWord의 개수만큼 동일해야 한다.
        // 하나를 빼준다.
        resultCount++;
        } else if (nwords.length() < firstWord.length() && cntWord == nwords.length()) {
        // nWords의 개수만큼 동일해야 한다.
        // 하나가 추가된다.
        resultCount++;
        }


        }

        System.out.println(resultCount);

        }
        }