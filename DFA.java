import java.util.Arrays;
import java.util.Scanner;

public class DFA {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int s=scanner.nextInt();
        int q=scanner.nextInt();
        int[] known=new int[n];
        for(int i=0; i<n; i++){
            known[i]=scanner.nextInt();
        }
        String[][] qs=new String[m][3];
        for(int i=0; i<m; i++){
            qs[i][0]=scanner.next();
            qs[i][1]=scanner.next();
            qs[i][2]=scanner.next();
        }
        String[] words=new String[q];
        for(int i=0; i<q; i++){
            words[i]=scanner.next();
        }
        for(int i=0; i<q; i++){
            String word=words[i];
            check(word, qs, s, m, known);
            print(word, qs, s, m);
        }
    }

    public static void check(String word, String[][] qs, int s, int m, int[] known){
        int len=word.length();
        boolean start=false;
        char c=word.charAt(0);
        for(int i=0; i<m; i++){
            if(qs[i][0].charAt(0)==c && Integer.parseInt(qs[i][1])==s){
                start=true;
            }
        }
        if(!start){
            System.out.print("No ");
            return;
        }
        int st=s;
        boolean[] flag=new boolean[len];
        for(int i=0; i<len; i++){
            char ch=word.charAt(i);
            for(int j=0; j<m; j++){
                if(qs[j][0].charAt(0)==ch && Integer.parseInt(qs[j][1])==st){
                    flag[i]=true;
                    st=Integer.parseInt(qs[j][2]);
                    break;
                }
            }
        }
        if(known[st-1]==0){
            System.out.print("No ");
            return;
        }
        for(int i=0; i<len; i++){
            if(!flag[i]){
                System.out.print("No ");
                return;
            }
        }
        System.out.print("Yes ");
    }

    public static void print(String word, String[][] qs, int s, int m){
        char c=word.charAt(0);
        boolean start=false;
        for(int i=0; i<m; i++){
            if(qs[i][0].charAt(0)==c && Integer.parseInt(qs[i][1])==s){
                start=true;
            }
        }
        if(!start){
            System.out.println();
            return;
        } else {
            int st=s;
            int len=word.length();
            Outer: for(int i=0; i<len; i++){
                char ch=word.charAt(i);
                boolean flag=false;
                for(int j=0; j<m; j++){
                    if(qs[j][0].charAt(0)==ch){
                        if(Integer.parseInt(qs[j][1])==st){
                            System.out.print(qs[j][2]+" ");
                            //System.out.println(qs[j][0]+" "+st+" "+qs[j][1]);
                            st=Integer.parseInt(qs[j][2]);
                            flag=true;
                            continue Outer;
                        }

                    }
                }
                if(!flag){
                    System.out.println();
                    return;
                }
            }
        }
        System.out.println();
    }
}
