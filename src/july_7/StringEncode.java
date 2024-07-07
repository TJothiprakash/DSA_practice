package july_7;
class StringEncode {
    public static void main(String[] args) {
        StringEncode stringEncode= new StringEncode();
        String test= "dart";int s= 3;
       String ans= stringEncode.getEncryptedString(test,s);
        System.out.println(ans);
    }
    public String getEncryptedString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // Calculate the new index for each character
            int newIndex = (i + k) % n;
            sb.append(s.charAt(newIndex));
        }

        return sb.toString();
    }
}
