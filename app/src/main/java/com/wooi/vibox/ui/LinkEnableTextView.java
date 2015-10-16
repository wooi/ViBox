package com.wooi.vibox.ui;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.wooi.vibox.logger.Logger;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/10/15.
 */
public class LinkEnableTextView extends TextView {
    private Pattern screenNamePattern = Pattern.compile("(^\\\\@[\\u4e00-\\u9fa5\\\\a-zA-Z0-9\\\\_\\\\w]+)|(^@[a-zA-Z0-9]+)");
    private Pattern hashTagsPattern = Pattern.compile("(#[\\u4e00-\\u9fa5\\\\w]+#+ )");
    private Pattern hyperLindsPattern = Pattern.compile("([Hh][tT][tT][pP]?:\\/\\/[^ ,'\">\\]\\)]*[^\\. ,'\">\\]\\)])");
    private ArrayList<HyperLink> hyperLinkList;
    private TextLinkClickListener mListener;

    public LinkEnableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        hyperLinkList = new ArrayList<HyperLink>();
    }

    public void gatherLinksForText(String text) {
        SpannableString linkableText = new SpannableString(text);

        gatherLins(hyperLinkList, linkableText, screenNamePattern);
//        gatherLins(hyperLinkList, linkableText, hashTagsPattern);
//        gatherLins(hyperLinkList, linkableText, hyperLindsPattern);

        for (int i = 0; i < hyperLinkList.size(); i++) {
            HyperLink linkSpec = hyperLinkList.get(i);
            try {
                linkableText.setSpan(linkSpec.span, linkSpec.start, linkSpec.end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } catch (IndexOutOfBoundsException e) {
                Logger.e(linkSpec.span.clickedSpan);
                Logger.e(linkSpec.start +"======"+ linkSpec.end);
            }

        }
        setText(linkableText);
    }

    private void gatherLins(ArrayList<HyperLink> hyperLinkList, SpannableString spannableString, Pattern pattern) {
        Matcher matcher = pattern.matcher(spannableString);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            HyperLink hyperLink = new HyperLink();
            hyperLink.textSpan = spannableString.subSequence(start, end);
            hyperLink.span = new InternalURLSpan(hyperLink.textSpan.toString());
            hyperLink.start = start;
            hyperLink.end = end;
            hyperLinkList.add(hyperLink);
        }

    }

    public void setOnTextLinkedClickListener(TextLinkClickListener textLinkedClickListener) {
        this.mListener = textLinkedClickListener;
        MovementMethod movementMethod = this.getMovementMethod();
        if ((movementMethod == null) && !(movementMethod instanceof LinkMovementMethod)) {
            if (this.getLinksClickable()) {
                this.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    class HyperLink {
        CharSequence textSpan;
        InternalURLSpan span;
        int start;
        int end;
    }

    class InternalURLSpan extends ClickableSpan {
        String clickedSpan;

        InternalURLSpan(String clickedString) {
            this.clickedSpan = clickedString;
        }

        @Override
        public void onClick(View widget) {
            mListener.onTextLinkClick(widget, clickedSpan);
        }
    }

    public interface TextLinkClickListener {
        void onTextLinkClick(View textView, String clickedString);
    }
}
