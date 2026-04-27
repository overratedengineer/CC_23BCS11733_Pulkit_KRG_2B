class Solution {
    public ArrayList<Integer> rabinKarp(String text, String pattern) {
        ArrayList<Integer> res=new ArrayList<>();
        int n = text.length(),m=pattern.length();
        if (m > n) return res;

        int d =256, q=101;
        int p =0, t=0, h=1;

        for (int i =0; i <m-1; i++) h=(h*d)%q;

        for (int i=0; i<m;i++) {
            p=(p*d+pattern.charAt(i))%q;
            t=(t*d+text.charAt(i))%q;
        }

        for (int i=0;i<=n-m;i++) {
            if (p==t) {
                int j=0;
                for (;j<m;j++) {
                    if (text.charAt(i+j)!=pattern.charAt(j)) break;
                }
                if (j==m) res.add(i);
            }

            if (i<n-m) {
                t=(d*(t-text.charAt(i)*h)+text.charAt(i+m))%q;
                if (t<0)t+=q;
            }
        }
        return res;
    }
}