package com.chang.simpleblog.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

/**
 * 数字工具类
 * @Author: chang.tong
 * @Date: 2019/8/13 15:49
 * @Version 1.0
 */
public class NumberTool {
    private static final int FourDecimalMedian = 4;
    public static final int YI = 100000000;
    public static final int WAN = 10000;
    private static final String[] unms = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static final String[] digits = new String[]{"", "十", "百", "千"};
    private static final String[] units = new String[]{"", "万", "亿", "万亿"};

    public NumberTool() {
    }

    public static Integer safeToInteger(Object o, Integer dv) {
        Integer r = dv;
        if (o != null) {
            try {
                r = (new BigDecimal(String.valueOf(o))).intValue();
            } catch (Exception var4) {
                ;
            }
        }

        return r;
    }

    public static Double safeToDouble(Object o, Double dv) {
        Double r = dv;
        if (o != null) {
            try {
                r = (new BigDecimal(String.valueOf(o))).doubleValue();
            } catch (Exception var4) {
                ;
            }
        }

        return r;
    }

    public static Double safeToDouble(Object o, Double dv, int round) {
        Double r = dv;
        if (o != null) {
            try {
                r = (new BigDecimal(String.valueOf(o))).doubleValue();
            } catch (Exception var5) {
                ;
            }
        }

        r = (new BigDecimal(r)).setScale(round, 4).doubleValue();
        return r;
    }

    public static Float safeToFloat(Object o, Float dv) {
        Float r = dv;
        if (o != null) {
            try {
                r = (new BigDecimal(String.valueOf(o))).floatValue();
            } catch (Exception var4) {
                ;
            }
        }

        return r;
    }

    public static Float safeToFloat(Object o, Float dv, int round) {
        Float r = dv;
        if (o != null) {
            try {
                r = (new BigDecimal(String.valueOf(o))).floatValue();
            } catch (Exception var5) {
                ;
            }
        }

        r = (new BigDecimal((double)r)).setScale(round, 4).floatValue();
        return r;
    }

    public static BigDecimal stringToBigDecimal(String paraValue) {
        try {
            BigDecimal bDecimal = null;
            return paraValue.indexOf("%") == -1 ? (new BigDecimal(Double.valueOf(paraValue.trim().replace(",", "")))).setScale(4, 4) : (new BigDecimal(Double.valueOf(paraValue.trim().replace("%", "")) / 100.0D)).setScale(4, 4);
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static BigDecimal stringToBigDecimalTwoSpilt(String paraValue) {
        try {
            BigDecimal bDecimal = null;
            return paraValue.indexOf("%") == -1 ? (new BigDecimal(Double.valueOf(paraValue.trim().replace(",", "")))).setScale(2, 4) : (new BigDecimal(Double.valueOf(paraValue.trim().replace("%", "")) / 100.0D)).setScale(4, 4);
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static BigDecimal aSubtractB(BigDecimal aParaValue, BigDecimal bParaValue) {
        try {
            return aParaValue.subtract(bParaValue).setScale(4, 4);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static BigDecimal aDivideB(BigDecimal aParaValue, BigDecimal bParaValue) {
        try {
            return aParaValue.divide(bParaValue, 4).setScale(4, 4);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static double avg(double[] sequenceArr) {
        if (sequenceArr != null && sequenceArr.length > 0) {
            double sum = 0.0D;
            int T = sequenceArr.length;

            for(int i = 0; i < T; ++i) {
                sum += sequenceArr[i];
            }

            return sum / (double)T;
        } else {
            return 0.0D;
        }
    }

    public static double round(double value, int count) {
        int t = (int)Math.pow(10.0D, (double)(count + 1));
        return (double)Math.round(value * (double)t) / (double)t;
    }

    public static Double getFourDecimalNumber(Number number) {
        if (number != null && 0.0D != number.doubleValue()) {
            NumberFormat format = new DecimalFormat("##0.0000");
            return Double.valueOf(format.format(number));
        } else {
            return 0.0D;
        }
    }

    public static Integer convertMapKeyToInt(Map map, String key, Integer defaultValue) {
        return safeToInteger(map.get(key), defaultValue);
    }

    public static Integer convertMapKeyToInt(Map map, String key) {
        return convertMapKeyToInt(map, key, 0);
    }

    public static String convertIntArrayToString(int[] intArray) {
        if (intArray.length <= 0) {
            return "";
        } else {
            String _string = "";
            int[] var2 = intArray;
            int var3 = intArray.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                int _int = var2[var4];
                _string = _string + (_string.equals("") ? (new Integer(_int)).toString() : "," + (new Integer(_int)).toString());
            }

            return _string;
        }
    }

    public static Double safeAdd(Double v1, Double v2) {
        if (v1 != null && v2 != null) {
            BigDecimal b1 = new BigDecimal(Double.toString(v1));
            BigDecimal b2 = new BigDecimal(Double.toString(v2));
            return b1.add(b2).doubleValue();
        } else {
            return null;
        }
    }

    public static Double safeSub(Double v1, Double v2) {
        if (v1 != null && v2 != null) {
            BigDecimal b1 = new BigDecimal(Double.toString(v1));
            BigDecimal b2 = new BigDecimal(Double.toString(v2));
            return b1.subtract(b2).doubleValue();
        } else {
            return null;
        }
    }

    public static Double safeDiv(Double v1, Double v2) {
        return safeDiv(v1, v2, 4);
    }

    public static Double safeDiv(Double v1, Double v2, int sacle) {
        if (v1 != null && v2 != null && v2 != 0.0D) {
            BigDecimal b1 = new BigDecimal(Double.toString(v1));
            BigDecimal b2 = new BigDecimal(Double.toString(v2));
            return b1.divide(b2, sacle, 4).doubleValue();
        } else {
            return null;
        }
    }

    public static Double safeMul(Double v1, Double v2) {
        if (v1 != null && v2 != null) {
            BigDecimal b1 = new BigDecimal(Double.toString(v1));
            BigDecimal b2 = new BigDecimal(Double.toString(v2));
            return b1.multiply(b2).doubleValue();
        } else {
            return null;
        }
    }

    /** @deprecated */
    @Deprecated
    public static String formateNumber(double number, String pattern) {
        if (number == 0.0D) {
            return "0";
        } else {
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            return decimalFormat.format(number);
        }
    }

    public static String formatNumber(Object number, String pattern) {
        if (number != null && !number.toString().equals("")) {
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            return decimalFormat.format(safeToDouble(number, 0.0D));
        } else {
            return "";
        }
    }

    public static Boolean isNum(Object object) {
        if (object instanceof Number) {
            return true;
        } else {
            boolean flag = false;
            if (safeToInteger(object, (Integer)null) != null || safeToDouble(object, (Double)null) != null || safeToFloat(object, (Float)null) != null) {
                flag = true;
            }

            return flag;
        }
    }

    public static String numberToChinese(Integer number) {
        return transfrom(StringUtil.safeToString(number, ""));
    }

    private static String transfrom(String x) {
        if (null == x) {
            return "";
        } else if (0 == x.length()) {
            return "";
        } else if (!checkIsNumbers(x)) {
            return "";
        } else if (x.length() > 16) {
            return "";
        } else if (x.equals("0")) {
            return "零";
        } else {
            int fm;
            for(fm = 0; fm < x.length() && x.charAt(fm) == '0'; ++fm) {
                ;
            }

            x = x.substring(fm);
            String result = "";
            int p = 0;
            int m = x.length() % 4;
            int k = m > 0 ? x.length() / 4 + 1 : x.length() / 4;

            for(int i = k; i > 0; --i) {
                int len = 4;
                if (i == k && m != 0) {
                    len = m;
                }

                String s = x.substring(p, p + len);
                int le = s.length();

                for(int j = 0; j < le; ++j) {
                    int n = Integer.parseInt(s.substring(j, j + 1));
                    if (0 == n) {
                        if (j < le - 1 && Integer.parseInt(s.substring(j + 1, j + 2)) > 0 && !result.endsWith(unms[0])) {
                            result = result + unms[0];
                        }
                    } else {
                        if (n != 1 || !result.endsWith(unms[0]) && result.length() != 0 || j != le - 2) {
                            result = result + unms[n];
                        }

                        result = result + digits[le - j - 1];
                    }
                }

                if (0 != Integer.parseInt(s)) {
                    result = result + units[i - 1];
                }

                p += len;
            }

            return result;
        }
    }

    private static boolean checkIsNumbers(String x) {
        if (null == x) {
            return false;
        } else {
            char[] var1 = x.toCharArray();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                Character c = var1[var3];
                if (c.compareTo('0') < 0 || c.compareTo('9') > 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
