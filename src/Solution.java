import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashSet;


public class Solution {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<>();
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader file = new BufferedReader(new FileReader("bigdic.txt"));
			String t;
			int originalLen=0;
			String originalWord;
			while((t=file.readLine())!=null) {
				set.add(t.toLowerCase());
			}
			String s,word;
			int n=Integer.parseInt(b.readLine());
			while((n--)>0){
				s=b.readLine();
				if(s.contains(".")) {
					String[] domain = s.split("[.]");
					word=domain[0];
				}
				else {
					word=s.substring(1, s.length());
				}
				int num;
				originalLen = word.length();
				originalWord = new String(word);
				//start parsing the word
				ArrayList<String> sp = new ArrayList<>();
				sp.clear();
				int i,remaining=word.length(),j;
				for(j=0;j<100;j++) {
				for(i=word.length();i>=0;i--){
					if(set.contains(word.subSequence(0, i))) {
						//System.out.println(word.subSequence(0, i));
						sp.add(word.substring(0, i));
						word = word.substring(i, word.length());
						break;
					} else {
					try {
						 num = Integer.parseInt(word.subSequence(0, i).toString());
						 sp.add(String.valueOf(num));
						 word= word.substring(i, word.length());
						 break;
					} catch (NumberFormatException ex) {
						;
					}
							
						
					}
					
				}
				if(word.length()==0) {
					break;
				}
				}
				
				int sum;
				sum=0;
				
				for(i=0;i<sp.size();i++){
					sum = sum + sp.get(i).length();
				}
				if(sum == originalLen) {
				for(int ji=0;ji<sp.size();ji++) {
					System.out.print(sp.get(ji));
					if(ji!=sp.size()-1)
						System.out.print(" ");
				}
				System.out.println("");
				
				}
				else {
					System.out.println(originalWord);
					System.out.println(sp);
				}
				
			}
	}

}
