package font.khanbeiki.moslem.font;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public class ButtonCustomFont extends Button {
    String customFont;

    public ButtonCustomFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        style(context, attrs);
    }

    public ButtonCustomFont(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        style(context, attrs);
    }

    private void style(Context context, AttributeSet attrs) {

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ButtonCustomFont);
        int cf = a.getInteger(R.styleable.ButtonCustomFont_fontName, 0);
        int fontName = 0;
        switch (cf) {
            case 1:
                fontName = R.string.IRANSansMobile_UltraLight;
                break;
            case 2:
                fontName = R.string.IRANSansMobile_Light;
                break;
            case 3:
                fontName = R.string.IRANSansMobile_Medium;
                break;
            case 4:
                fontName = R.string.IRANSansMobile_Bold;
                break;
            default:
                fontName = R.string.IRANSansMobile_Light;
                break;
        }

        customFont = getResources().getString(fontName);

        Typeface tf = Typeface.createFromAsset(context.getAssets(), customFont + ".ttf");
        setTypeface(tf);
        a.recycle();
    }
}
