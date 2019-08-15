package com.chang.simpleblog.common.utils;
import org.apache.commons.collections.MapUtils;
import org.springframework.util.StringUtils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @Author: chang.tong
 * @Date: 2019/8/13 15:36
 * @Version 1.0
 */
public class StringUtil extends StringUtils {
    public StringUtil() {
    }

    public static String replaceSpecialChar(String str) {
        return null != str && !str.trim().equals("") ? str.replace("\\/", "").replace("<", "").replace(">", "").replace(":", "").replace("?", "").replace("|", "").replace("\"", "").replace("*", "") : "nulltitle";
    }

    public static String replaceXSS(String str) {
        if (str == null) {
            return str;
        } else {
            String r = new String(str);
            String[] strs = new String[]{"|", "&", ";", "$", "%", "@", "'", "\"", "\\'", "\\\"", "<", ">", "(", ")", "+", "\n", "\r", ",", "\\"};
            String[] var3 = strs;
            int var4 = strs.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String s = var3[var5];
                r = r.replace(s, "");
            }

            return r;
        }
    }

    public static String replaceEscape(String str) {
        if (str == null) {
            return str;
        } else {
            StringBuffer sb = new StringBuffer();
            char[] chars = str.toCharArray();
            char[] var3 = chars;
            int var4 = chars.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                char c = var3[var5];
                boolean isok = c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
                if (isok) {
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }

    public static String convertMapKeyToString(Map<String, String> map, String key, String defaultValue) {
        return MapUtils.getString(map, key, defaultValue);
    }

    @Deprecated
    public static String convertMapKeyToInt(Map<String, String> map, String key) {
        return convertMapKeyToString(map, key, "");
    }

    public static String escapeHtml(String o) {
        return o == null ? "" : o.replace(">", "&gt;").replace(" ", "&nbsp;").replace("<", "&lt;").replace("\n", "<br/>");
    }

    public static String replaceHtml(String str) {
        String pattern1 = "<(.[^>]*)>";
        return str.replaceAll(pattern1, "");
    }

    public static String formatFileSize(double size) {
        String[] rank = new String[]{"B", "K", "M", "G"};

        int c;
        for(c = 0; size > 1024.0D; ++c) {
            size /= 1024.0D;
        }

        DecimalFormat df = new DecimalFormat("0.00");
        String result = df.format(size) + (c > rank.length ? rank[rank.length - 1] : rank[c]);
        return result;
    }

    public static String safeToString(Object o, String dv) {
        String r = dv;
        if (o != null) {
            r = String.valueOf(o);
            if (StringUtils.isEmpty(r)) {
                r = dv;
            }
        }
        return r;
    }

    public static Boolean safeToBoolean(Object o, Boolean dv) {
        Boolean r = dv;
        if (o != null) {
            try {
                r = Boolean.parseBoolean(o.toString());
            } catch (Exception var4) {
                return dv;
            }
        }

        return r;
    }

    public static List<Integer> safeToIntegerArray(Object object, String separator) {
        List<Integer> results = new ArrayList();
        if (object == null) {
            return results;
        } else {
            String str = object.toString();
            if (isStrEmpty(str)) {
                return results;
            } else {
                String[] strArr = str.split(separator);
                String[] var5 = strArr;
                int var6 = strArr.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    String s = var5[var7];
                    Integer result = NumberTool.safeToInteger(s, (Integer)null);
                    results.add(result);
                }

                return results;
            }
        }
    }

    public static boolean isChinese(String s) {
        return s == null ? false : Pattern.matches("[一-\u9fff]+", s);
    }

    public static String formatListToString(List list) {
        if (list == null) {
            return null;
        } else if (list.size() == 0) {
            return "";
        } else {
            StringBuffer buffer = new StringBuffer();
            Iterator var2 = list.iterator();

            while(var2.hasNext()) {
                Object obj = var2.next();
                buffer.append(",").append(obj == null ? "" : obj.toString().trim());
            }

            if (buffer.length() > 0) {
                buffer.deleteCharAt(0);
            }

            return buffer.toString();
        }
    }

    public static List<String> formatStringToList(String s, String regex) {
        List<String> rstList = new ArrayList();
        if (isStrEmpty(regex)) {
            regex = ",";
        }

        if (isStrEmpty(s)) {
            return rstList;
        } else {
            String[] array = s.split(regex);
            String[] var4 = array;
            int var5 = array.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String str = var4[var6];
                rstList.add(str);
            }

            return rstList;
        }
    }

    public static List<String> formatStringToListByComma(String s) {
        List<String> rstList = new ArrayList();
        getListElementByString(rstList, s);
        return rstList;
    }

    private static void getListElementByString(List list, String s) {
        if (isStrEmpty(s)) {
            list.add("");
        } else if (s.indexOf(",") == -1) {
            list.add(s);
        } else {
            String temp = s.substring(0, s.indexOf(","));
            list.add(isStrEmpty(temp) ? "" : temp);
            getListElementByString(list, s.substring(s.indexOf(",") + 1));
        }

    }

    public static boolean isUnixOS(String fileName) {
        if (!isStrEmpty(fileName)) {
            String separator = fileName.substring(0, 1);
            return "/".equals(separator);
        } else {
            return false;
        }
    }

    public static boolean isStrEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    public static boolean isStrTrimEmpty(String str) {
        return str == null || str.trim().equals("");
    }

    public static List stringToArrayList(String str, String delim) {
        List list = new ArrayList();
        if (!isStrEmpty(str) && delim != null) {
            if (str.endsWith(delim)) {
                str = str.substring(0, str.length() - 1);
            }

            int index = str.indexOf(delim);
            if (index == -1) {
                list.add(str);
                return list;
            }

            while(index != -1) {
                String temp = str.substring(0, index);
                if (temp != null) {
                    if (temp.equals(delim)) {
                        list.add((Object)null);
                        index -= delim.length();
                    } else {
                        list.add(temp);
                    }

                    str = str.substring(index + 1);
                    index = str.indexOf(delim);
                } else {
                    ++index;
                }
            }

            list.add(str.trim());
        }

        return list;
    }

    public static String valueOf(Object obj) {
        return obj == null ? "" : String.valueOf(obj);
    }

    public static boolean hasContain(String[] array, String s) {
        if (isStrEmpty(s)) {
            return Boolean.FALSE;
        } else if (array != null && array.length != 0) {
            String[] var2 = array;
            int var3 = array.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String e = var2[var4];
                if (s.equals(e)) {
                    return Boolean.TRUE;
                }
            }

            return Boolean.FALSE;
        } else {
            return Boolean.FALSE;
        }
    }

    public static boolean isEmpty(List list) {
        boolean isEmpty = Boolean.TRUE;
        if (list != null && !list.isEmpty()) {
            Iterator var2 = list.iterator();

            while(var2.hasNext()) {
                Object o = var2.next();
                if (o != null && !isStrEmpty(o.toString())) {
                    isEmpty = Boolean.FALSE;
                    break;
                }
            }

            return isEmpty;
        } else {
            return isEmpty;
        }
    }

    public static boolean isNotEmpty(List list) {
        return !isEmpty(list);
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("^([0-9]\\d*)(\\.\\d*)?$");
        if (isStrEmpty(str)) {
            return false;
        } else {
            Matcher isNum = pattern.matcher(str);
            return isNum.matches();
        }
    }

    public static String specialCharReplace(String paraValue) {
        String[] typeXOne = new String[]{"1、", "2、", "3、", "4、", "5、", "6、", "7、", "8、", "9、", "10、", "11、", "12、", "13、", "14、", "15、", "16、", "17、", "18、", "19、", "20、"};
        String[] typeDone = new String[]{"一、", "二、", "三、", "四、", "五、", "六、", "七、", "八、", "九、", "十、", "十一、", "十二、", "十三、", "十四、", "十五、", "十六、", "十七、", "十八、", "十九、", "二十、"};
        String[] typeDKOne = new String[]{"（一）", "（二）", "（三）", "（四）", "（五）", "（六）", "（七）", "（八）", "（九）", "（十）", "（十一）", "（十二）", "（十三）", "（十四）", "（十五）", "（十六）", "（十七）", "（十八）", "（十九）", "（二十）"};
        String[] typeXDOne = new String[]{"1．", "2．", "3．", "4．", "5．", "6．", "7．", "8．", "9．", "10．", "11．", "12．", "13．", "14．", "15．", "16．", "17．", "18．", "19．", "20．"};
        String[] typeDKXOne = new String[]{"（1）", "（2）", "（3）", "（4）", "（5）", "（6）", "（7）", "（8）", "（9）", "（10）", "（11）", "（12）", "（13）", "（14）", "（15）", "（16）", "（17）", "（18）", "（19）", "（20）"};
        int i;
        if (paraValue.indexOf("、") != -1) {
            for(i = 0; i < typeXOne.length; ++i) {
                paraValue = paraValue.replace(typeXOne[i], "");
            }

            for(i = 0; i < typeDone.length; ++i) {
                paraValue = paraValue.replace(typeDone[i], "");
            }
        }

        if (paraValue.indexOf("（") != -1) {
            for(i = 0; i < typeDKOne.length; ++i) {
                paraValue = paraValue.replace(typeDKOne[i], "");
            }

            for(i = 0; i < typeDKXOne.length; ++i) {
                paraValue = paraValue.replace(typeDKXOne[i], "");
            }
        }

        if (paraValue.indexOf("．") != -1) {
            for(i = 0; i < typeXDOne.length; ++i) {
                paraValue = paraValue.replace(typeXDOne[i], "");
            }
        }

        return paraValue;
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
}
