package numbers;

//1. Let NumberConverter be an interface. What must replace the blank?
public interface NumberConverter{
    public double binaryToDecimal(String b) throws Exception;
    public double hexadecimalToDecimal(String h);
    public double octalToDecimal(String n);
        }
