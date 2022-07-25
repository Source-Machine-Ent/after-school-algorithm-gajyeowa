package level1;
import java.util.*;

class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {

        //중복 제거
        HashSet<String> hashSet = new HashSet<String>(Arrays.asList(report));
        String[] reportArr = hashSet.toArray(new String[0]);

        //신고 유저 저장
        //Key는 신고한 사람, Value는 신고 당한 사람 리스트
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        //Key는 이름, Value는 신고당한 횟수
        HashMap<String, Integer> count = new HashMap<String, Integer>();

        for(String reportStr : reportArr){
            // str[0] == 신고한 사람, str[1] == 신고한 사람
            String[] str = reportStr.split(" ");

            // 신고당한 사람 리스트
            List<String> list = hashMap.get(str[0]);

            // 리스트가 있으면 신고 당한 사람 추가
            if(list != null){
                list.add(str[1]);
                hashMap.put(str[0],list);
            }else {
                // 리스트 없으면 새로 리스트 만들어서 추가
                List<String> newList = new ArrayList<String>();
                newList.add(str[1]);
                hashMap.put(str[0],newList);
            }
        }

        for (Map.Entry<String, List<String>> entry : hashMap.entrySet()){
            // Key에게 신고당한 사람 리스트
            List<String> list = entry.getValue();
            for(String str : list){
                // 신고 당한 횟수를 1씩 더한다
                if(count.get(str) != null){
                    int cnt = count.get(str);
                    count.put(str, cnt+1);
                } else{
                    count.put(str, 1);
                }
            }
        }

        // 결과 담을 맵
        HashMap<String, Integer> resultMap = new HashMap<String, Integer>();

        for(int i=0; i < id_list.length; i++){
            // 신고한 사람
            String id = id_list[i];
            // 신고당한 사람 목록
            List<String> list = hashMap.get(id);
            // 신고당한 사람 목록의 이름으로 검색해서 숫자가 k이상인지 확인
            if(list != null){
                for(String str : list){
                    int num = count.get(str);
                    if(num >= k){
                        if(resultMap.get(id) != null){
                            int val = resultMap.get(id);
                            resultMap.put(id, val + 1);
                        }else{
                            resultMap.put(id, 1);
                        }
                    }
                }
            } else{
                resultMap.put(id, 0);
            }

        }

        // 결과 담을 리스트
        int[] resultArr = new int[id_list.length];

        for(int i = 0; i < resultArr.length; i++){
            String id = id_list[i];
            Integer result = resultMap.get(id);

            if(result != null){
                resultArr[i] = resultMap.get(id);
            } else{
                resultArr[i] = 0;
            }

        }

        return resultArr;
    }
}


