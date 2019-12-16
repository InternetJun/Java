package 牛客网;
/**
 * {请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中， * 匹配是指字符串的所有字符匹配整个模式。  {@*作用是可以所有的， @0,1,+inf的实现。}
 * 例如，字符串"aaa"与模式"a.a"和"a{@b* 和 a相同}ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * }不懂意思。
 * {@需要知道的是怎么会满足那个意思呢?}
 * 怎么去匹配所有的字符串问题。有的是？
 * */
public class Regx52 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {//利用的是字符char来比较的意思。
            return false;
        }
        return matchRecur(str, pattern, 0, 0);
    }

    public boolean matchRecur(char[] str, char[] pattern, int s, int p) {
        //两个对比指针走到最后，则说明匹配成功
        //问题是定义的问题啊.怎么去使用的啊.!!! 还有的是说的有的是说?
        if (s == str.length && p == pattern.length) {
            return true;
        }
        //模式串比文本先到末尾肯定没匹配成功，要想匹配成功必须是的条件是：模式串的长度>=文本串就是长度的比价.
        if (p == pattern.length && s < str.length) {
            return false;
        }
		/*现在开始正式分析
		第一个字符不相等的话，就直接返回false;
		第二个字符就要分情况讨论了
			1、当模式中的第二字符不是   * 时，那就大家都往后比呗  ，文本和模式都往后移一步。
			   abc...(文本串)
			   abc...(模式串)
			   代码：(记住，由于模式串的长度>=文本，所以只要考虑文本是否越界就行)
			  if((s<str.length&&str[s]==pattern[p])||(pattern[p]=='.'&&s<str.length)) {
				  return matchRecur(str, pattern, s+1, p+1);
			  }
			2、当模式中第二个字符是 * 时，这个情况就有四种情况要考虑了
		                第一个字符不相等，例子ab和c*ab，一个a一个c，且模式串第二个* 则，直接patten向后跳两个指针：
				    return matchRecur(str, pattern, s, p+2);
			     当第一个字符相等时了？就有三种情况要考虑在内了    //**被忽略的意思了。*
			       1、abc和a*bc  模式后移2字符,文本后移1个，相当于*被忽略  matchRecur(str, pattern, s+1, p + 2)
			       2、abc和a*abc 模式后移2字符，相当于{x*}被忽略；matchRecur(str, pattern, s, p + 2)
			       3、aaaabc和a*abc 字符串后移1字符，模式不变，即继续匹配字符下一位，因为{*可以匹配多位}；matchRecur(str, pattern, s+1, p)
	  */

        //用代码实现上述的逻辑流程

		/*1、当模式中的第二字符不是   * 时，那就大家都往后比呗  ，文本和模式都往后移一步。
		   abc...(文本串)
		   abc...(模式串)
		   代码：(记住，由于模式串的长度>=文本，所以只要考虑文本是否越界就行)
		  if((s<str.length&&str[s]==pattern[p])||(pattern[p]=='.'&&s<str.length)) {
			  return matchRecur(str, pattern, s+1, p+1);
		  } */
        if ((s < str.length && str[s] == pattern[p]) || (s < str.length && pattern[p] == '.')) {
            return matchRecur(str, pattern, s + 1, p + 1);
        }

		/*2、当模式中第二个字符是 * 时，这个情况就有四种情况要考虑了
		（1）例子ab和c*ab
		  第一个字符不相等，一个a一个c，且模式串第二个* 则，直接patten向后跳两个指针：
		    return matchRecur(str, pattern, s, p+2);
	     当第一个字符相等时了？就有三种情况要考虑在内了
	       1、abc和a*bc  模式后移2字符,文本后移1个，相当于*被忽略  matchRecur(str, pattern, s+1, p + 2)
	       2、abc和a*abc 模式后移2字符，相当于x*被忽略；matchRecur(str, pattern, s, p + 2)
	       3、aaaabc和a*abc 字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；matchRecur(str, pattern, s+1, p)*/

        if (p < pattern.length - 1 && pattern[p + 1] == '*') {
            if ((s < str.length && str[s] == pattern[p]) || (s < str.length && pattern[p] == '.')) {
                //下面或最后结果只有有个为真，就行，因为它必走下面三个条件
                return matchRecur(str, pattern, s + 1, p + 2) ||//1个走位，2个，inf走位。
                        matchRecur(str, pattern, s,  p + 2)||
                        matchRecur(str, pattern, s + 1, p);
            } else {
                return matchRecur(str, pattern, s, p + 2);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
