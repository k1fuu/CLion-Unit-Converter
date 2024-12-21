public class UnitConverterNative {
    static {
        System.loadLibrary("UnitConverter"); // Имя вашей DLL
    }

    public native double convert(double value);
}
