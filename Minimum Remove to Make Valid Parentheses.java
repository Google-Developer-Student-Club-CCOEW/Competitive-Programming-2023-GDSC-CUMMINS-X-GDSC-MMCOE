class Solution {
    public String minRemoveToMakeValid(String s) {
        
        char ch[]=s.toCharArray();
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='(' || ch[i]==')'){
                if(ch[i]=='(')
                    st.push(i);
                else if(ch[i]==')' && !st.isEmpty()){
                    st.pop();
                }
                else{
                    ch[i]='@';
                }
            }
        }
        while(!st.isEmpty()){
            ch[st.pop()]='@';
        }
        String ans="";
        for(int i=0;i<ch.length;i++){
            if(ch[i]!='@'){
                ans+=ch[i];
            }
        }
        return ans;     
    }
}
