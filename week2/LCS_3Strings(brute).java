import java.util.*;
public class Main{
  /* Time complexity ≈ O(2^n + 2^m + 2^k + 4^L) , where n,m,k are lengths of the 3 input strings */ 

    static Set<String> getSubseq(String str){
        Set<String> subs = new HashSet<>();
        
        int n = str.length();
        for(int i=1;i<(1<<n);i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if((i & (1 << j))>0){
                    sb.append(str.charAt(j));
                }
            }
            subs.add(sb.toString());
        }
        return subs;
    }
    public static int lcsBrute(String s1,String s2,String s3){
        Set<String> subs1 = getSubseq(s1);
        Set<String> subs2 = getSubseq(s2);
        Set<String> subs3 = getSubseq(s3);
        
        subs1.retainAll(subs2);
        subs1.retainAll(subs3);
        
        int maxLen = 0;
        for(String s : subs1){
            maxLen = Math.max(maxLen,s.length());
        }
        return maxLen;
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String s3 = sc.next();
        System.out.println(lcsBrute(s1,s2,s3));
    }
}
