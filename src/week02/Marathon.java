package week02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Marathon {

    public static void main(String[] args) {
        // test01
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution3(participant, completion));
    }

    /*
     * 첫번째 방법 -> 테스트는 통과하였지만 효율성에서 틀림
     * */
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        for (int i = 0; i < completion.length; i++) {
            for (int j = 0; j < participant.length; j++) {
                if (participant[j].equals(completion[i])) {
                    participant[j] = "";
                    break;
                }
            }
        }
        for (int i = 0; i < participant.length; i++) {
            if (participant[i].length() > 0) {
                answer = participant[i];
            }

        }
        return answer;
    }

    /*
     * 두번째 풀이방법
     * */
    public static String solution2(String[] participant, String[] completion) {
        String answer = "";
        String result = "";
        /*
         문제 풀이 방식
         1. Arrays.sort()를 통해 정렬한다.
         2. 반복문을 실행하여 participant와 completion 다른 값을 return한다.
         */

        Arrays.sort(participant);
        Arrays.sort(completion);

        System.out.println(Arrays.toString(participant));
        System.out.println(Arrays.toString(completion));

        for (int i = 0; i < completion.length; i++) {
            if (!completion[i].equals(participant[i])) {
                answer = participant[i];
                break;
            }
        }

        if (answer.equals("")) {
            answer = participant[participant.length - 1];
        }
        return answer;
    }

    public static String solution3(String[] participants, String[] completions) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participants.length; i++) {
            if (map.get(participants[i]) == null) {
                map.put(participants[i], 1);
            } else {
                map.put(participants[i], map.get(participants[i]) + 1);
            }
        }
        for (int i = 0; i < completions.length; i++) {
            if (map.containsKey(completions[i])) {
                map.put(completions[i], map.get(completions[i]) - 1);
            }
        }

        return map.entrySet().stream()
            .filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey)
            .findFirst().orElse("");
    }


}
