package io.isoft;

/**
 * 公共的加密解密类
 * 
 *
 */
public class SupSafe {

    public SupSafe() {
        super();
        // TODO 自动生成构造函数存根
    }

    /**
     * 密钥
     */
    private static String codes = "`1234567890-=~!@#$%^&*()_+qwertyuiop[]\\QWERTYUIOP{}|asdfghjkl;ASDFGHJKL:zxcvbnm,./ZXCVBNM<>? ";

    /**
     * 解密
     *
     * @param str
     *            输入密文
     * @return String 返回明文
     */
    public static String getCrack(String str) {
    	if(str==null)
    		return "";
        String str_crack = "";
        char c;
        char c1;
        int i, j, k;
        int strlength = str.length();
        int codeslength = codes.length();
        for (i = 0; i < strlength; i++) {
            c = str.charAt(i);
            for (j = 0; j < codeslength; j++) {
                c1 = codes.charAt(j);
                if (c == c1) {
                    break;
                }
            }
            k = j - i - 1;
            if (k < 0) {
                k += codeslength;
            }
            c = codes.charAt(k);
            str_crack = str_crack + c;
        }
        return str_crack;
    }

    /**
     * 加密
     *
     * @param str
     *            输入明文
     * @return String 返回密文
     */
    public static String getEncrypt(String str) {
        String str_encrypt = "";
        char c;
        char c1;
        int i, j, k;
        int strlength = str.length();
        int codeslength = codes.length();
        for (i = 0; i < strlength; i++) {
            c = str.charAt(i);
            for (j = 0; j < codeslength; j++) {
                c1 = codes.charAt(j);
                if (c == c1) {
                    break;
                }
            }
            k = j + i + 1;
            if (k > codeslength) {
                k %= codeslength;
            } else if (k <= 0) {
                k += codeslength;
            }
            c = codes.charAt(k);
            str_encrypt = str_encrypt + c;
        }
        return str_encrypt;
    }

}
