package exclude;

import java.util.ArrayList;

public class DomDistance {

    // use String to store the test case for convenience of sending the codes.
    final private static String testCaseString =
        "div\n" +
        "div\n" +
        "0\n" +
        "div#id\n" +
        "div#id\n" +
        "0\n" +
        "div#id.cls.btn\n" +
        "div#id.btn.cls\n" +
        "0\n" +
        "div\n" +
        "a\n" +
        "1\n" +
        "div#id\n" +
        "div\n" +
        "1\n" +
        "div#id\n" +
        "div#id.id\n" +
        "1\n" +
        "div#id.btn\n" +
        "div\n" +
        "2\n" +
        "div#id.btn\n" +
        "a.blue\n" +
        "3\n" +
        "div#id.btn.blue\n" +
        "div.blue.btn\n" +
        "1\n" +
        "div#id img.photo\n" +
        "a.btn\n" +
        "4\n" +
        "a.btn\n" +
        "div#id img.photo\n" +
        "5\n" +
        "div#id span.text a#link.btn\n" +
        "a#id.btn\n" +
        "4\n" +
        "a#id.btn\n" +
        "div#id span.text a#link.btn\n" +
        "6\n" +
        "div#id img.photo a.btn.share.link\n" +
        "a.btn div#id img.photo\n" +
        "3\n" +
        "a.btn div#id img.photo\n" +
        "div#id img.photo.bw a.btn.share.link\n" +
        "6\n" +
        "a#id.btn\n" +
        "div#id span.text a#id.share\n" +
        "6\n" +
        "div#id.btn.blue a#enter\n" +
        "a#enter.knob.green\n" +
        "3\n" +
        "a#enter.knob.green a#enter a#enter a#enter\n" +
        "a#enter.knob.green\n" +
        "3\n" +
        "a#enter.knob.green\n" +
        "a#enter.knob.green a#enter a#enter\n" +
        "4\n" +
        "a#enter\n" +
        "a#enter.knob.green a#enter a#enter\n" +
        "6\n" +
        "a#enter.knob.green\n" +
        "a#enter.knob.green a#enter a#enter\n" +
        "4\n" +
        "a#enter\n" +
        "a#enter.knob.green a#enter a#enter\n" +
        "6\n" +
        "div#nav-col.billboard-layout.cf.main-row div#yui_3_8_1_1_1382751082490_1382.main-col-wrapper div#hero-col.main-col1 div#yui_3_8_1_1_1382751082490_1381.hero-col-wrapper div#stream div#default-p_30345786.mod.view_default div#default-p_30345786-bd.bd.type_stream.type_stream_default ul#yui_3_8_1_1_1382751082490_1533 li#yui_3_8_1_1_1382751082490_1718.cf.content.has-image.voh-parent div#yui_3_8_1_1_1382751082490_1717.cf.wrapper div#yui_3_8_1_1_1382751082490_1716.body div#yui_3_8_1_1_1382751082490_1715.body-wrap p#yui_3_8_1_1_1382751082490_1740.mt-xxs.summary\n" +
        "div#nav-col.billboard-layout.cf.main-row div#yui_3_8_1_1_1382751082490_1382.main-col-wrapper div#hero-col.main-col1 div#yui_3_8_1_1_1382751082490_1381.hero-col-wrapper div#stream div#default-p_30345786.mod.view_default div#default-p_30345786-bd.bd.type_stream.type_stream_default ul#yui_3_8_1_1_1382751082490_1533 li#yui_3_8_1_1_1382751082490_1532.cf.content.voh-parent div#yui_3_8_1_1_1382751082490_1531.cf.wrapper div#yui_3_8_1_1_1382751082490_1530.body div#yui_3_8_1_1_1382751082490_1529.body-wrap p#yui_3_8_1_1_1382751082490_1554.mt-xxs.summary\n" +
        "11\n" +
        "div#masthead.billboard-layout.cf.main-col div#yui_3_8_1_1_1382751082490_1862.main-row-wrapper div#default-p_13838465.mod.view_default div#default-p_13838465-bd.bd.type_masthead.type_masthead_default div#yui_3_8_1_1_1382751082490_1861.clearfix.lightbg.mh-wrap.us.y-fp-pg-grad form#p_13838465-searchform.search-form fieldset#yui_3_8_1_1_1382751082490_1860.compact-enabled-fieldset div#p_13838465-searchwrapper.searchwrapper.selected.tabpanel div#yui_3_8_1_1_1382751082490_1859.focus.searchwrapper-border.y-srch-brdr div#fp-search-bdr.brdr-focus.clearfix.searchwrapper-inner.y-glbl-srch-bg-img div#yui_3_8_1_1_1382751082490_1858.input-wrapper input#p_13838465-p.compact-input-enabled.input-long.input-query.med-large\n" +
        "div#masthead.billboard-layout.cf.main-col div#yui_3_8_1_1_1382751082490_1862.main-row-wrapper div#default-p_13838465.mod.view_default div#default-p_13838465-bd.bd.type_masthead.type_masthead_default div#yui_3_8_1_1_1382751082490_1861.clearfix.lightbg.mh-wrap.us.y-fp-pg-grad form#p_13838465-searchform.search-form fieldset#yui_3_8_1_1_1382751082490_1860.compact-enabled-fieldset div#p_13838465-searchwrapper.searchwrapper.selected.tabpanel div#yui_3_8_1_1_1382751082490_1859.searchwrapper-border.y-srch-brdr div#fp-search-bdr.clearfix.searchwrapper-inner.y-glbl-srch-bg-img div#yui_3_8_1_1_1382751082490_1858.input-wrapper input#p_13838465-p.compact-input-enabled.input-long.input-query.med-large\n" +
        "2\n" +
        "header.cf.header div.nav-bar div.lc form.search-form fieldset input.search-field\n" +
        "header.cf.header div.nav-bar div.lc div.header-social ul.inline-list.social-list.sprite-social\n" +
        "8\n" +
        "header.cf.header div.nav-bar div.lc form.search-form fieldset input.search-field\n" +
        "div.fluid.flush.homepage.split div.flush.lc.lc-island div.l-two-col div.l-main-container div.l-main ul#river1.lc-padding.river li#905418.river-block div.block.block-thumb div.block-content p.excerpt\n" +
        "30\n" +
        "div div#cnn_maincntnr div.cnn_contentarea.cnn_shdcamtt12010.cnn_shdcamtt1l250.cnn_t1lo_bnews.cnn_t1lo_refresh div#cnn_maintopt1 div#cnn_maint1lftf.breaking div#cnn_maintt1imgbul div.cnn_main10t1cntnt div.cnn_main10t1lcntr div.cnn_main10t1sbbin2c ul.cnn_bulletbin li.c_hpbullet4 a\n" +
        "div div#cnn_maincntnr div.cnn_contentarea.cnn_shdcamtt12010.cnn_shdcamtt1l250.cnn_t1lo_bnews.cnn_t1lo_refresh div#cnn_maintopt1 div#cnn_maint1lftf.breaking div#cnn_maintt1imgbul div.cnn_main10t1cntnt div.cnn_main10t1lcntr div div.cnn_main10t1stxt div#cnn_tc_t1_rich_text div.cnn_two_column_t_rich_text\n" +
        "9\n" +
        "div div#cnn_maincntnr div.cnn_contentarea.cnn_shdcamtt12010.cnn_shdcamtt1l250.cnn_t1lo_bnews.cnn_t1lo_refresh div#cnn_maintopt1 div#cnn_maintoplive div.cnn_mc2cntr div.cnn_mc23x1cnntr div#cnn_mc2_large1.cnn_mc2_img_right.cnn_mc2_large div div.cnn_mc2_text_left div.cnn_mc2_blurb a\n" +
        "div div#cnn_maincntnr div.cnn_contentarea.cnn_shdcamtt12010.cnn_shdcamtt1l250.cnn_t1lo_bnews.cnn_t1lo_refresh div#cnn_maintopprofile div#on_tv.cnn_hppersonal div#cnn_pmtvmodule div.cnn_hppersonalfeature div.cnn_pmtvmodddown.cnn_tsbnav form select\n" +
        "16\n" +
        "div#shell div#page.active.tabContent div#main div.baseLayout.wrap div.column.last div.layout.spanAB div.abColumn.column div.layout.module.wideB div.aColumn.column.opening div.columnGroup div.story p.summary\n" +
        "div#page.active.tabContent div#main div.baseLayout.wrap div.column.last div.layout.spanAB div.abColumn.column div.layout.module.wideB div.aColumn.column.opening div.columnGroup.first div.story p.summary\n" +
        "2\n" +
        "div#shell div#page.active.tabContent div#toolbar div#toolbarSearchContainer.toolbarSearchContainer-withad div#toolbarSearch.toolbarSearchActive div.inlineSearchControl form#searchForm input#hpSearchQuery.text\n" +
        "div#shell div#page.active.tabContent div#toolbar div#toolbarSearchContainer.toolbarSearchContainer-withad div#toolbarSearch div.inlineSearchControl form#searchForm input#hpSearchQuery.text\n" +
        "1\n" +
        "header.mh div.mh-stripe div.mh-stripe-wrap ul.mh-user-menu li.last a.omniture-tagged.omniture-tagged-291.show-login\n" +
        "div.ec-overlay div.login-wrap form#user-login.clearfix.context-user_login.ec-social.user-form div div#edit-name-wrapper.clearfix.form-item input#edit-name.form-email.form-text.required\n" +
        "24\n" +
        "div#page.container div#columns.clearfix div#leadspot.clearfix.grid-16 div#block-ec_homepage-ec_homepage_superhero.block.block-ec_homepage div.clearfix.content div#superhero.clearfix div.hero-superhero ul#hero.hero-multiple li.selected div.hero-item.hero-item-4 a.hero-tab.omniture-tagged.omniture-tagged-127 p.headline\n" +
        "div#page.container div#columns.clearfix div#column-content.clearfix.grid-10.grid-first div.grid-7.grid-first.push-3 div#homepage-center-inner section.news-package.typog-package article a.omniture-tagged.omniture-tagged-20 div h2.headline\n" +
        "25";

    // Element Class used for store each element
    static class Element {

        // Original String for testing
        private String original;

        // TagName
        private String tagName;

        // ID
        // set as "" when id is not provided
        private String id;

        // classes
        private ArrayList<String> classes = new ArrayList<String>();

        public Element(String tag) {
            original = tag;

            String[] tags = tag.split("\\.");

            tagName = tags[0].split("#")[0];

            id = tags[0].split("#").length == 2 ? tags[0].split("#")[1] : "";

            for (int i = 1; i < tags.length; i++) {
                classes.add(tags[i]);
            }
        }

        // The steps needed to created this tag from empty String
        public int getFullEdit() {
            int step = 1;
            if (id.length() >= 1) {
                step++;
            }
            return step + classes.size();
        }

        // toString for testing
        @Override
        public String toString() {
            return "Element{" +
                    "tagName='" + tagName + '\'' +
                    ", id='" + id + '\'' +
                    ", classes=" + classes +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Element element = (Element) o;

            if (original != null ? !original.equals(element.original) : element.original != null) return false;
            if (tagName != null ? !tagName.equals(element.tagName) : element.tagName != null) return false;
            if (id != null ? !id.equals(element.id) : element.id != null) return false;
            if (classes != null ? !classes.equals(element.classes) : element.classes != null) return false;

            return true;
        }

        // Method to calculate the edit distance between this element to some other Element
        // returns the steps.
        public int editTo(Element anotherElement) {

            if (tagName.equals(anotherElement.tagName)) {

                // Same tagName, then only need to consider ID and classes

                int step = 0;

                if (id.isEmpty()) {
                    if (!anotherElement.id.isEmpty()) {
                        step++;
                    }
                } else {
                    if (anotherElement.id.isEmpty()) {
                        step++;
                    } else {
                        if (!id.equals(anotherElement.id)) {
                            step += 2;
                        }
                    }
                }

                // Order does not matter in classes
                // Thus use two loops to count Classes

                // First loop : count classes that needs to be deleted
                for (String oneClass : classes) {
                    if (!anotherElement.classes.contains(oneClass)) {
                        step++;
                    }
                }
                // Second loop : count classes that needs to be added
                for (String theOtherOneClass : anotherElement.classes) {
                    if (!classes.contains(theOtherOneClass)) {
                        step++;
                    }
                }

                return step;

            } else {

                // Different tagName

                // Taken into account if only tagName is different
                if (id.equals(anotherElement.id) && classes.equals(anotherElement.classes)) {
                    return 1;
                }

                // Taken into account if id and classes are both empty
                if (id.isEmpty() && classes.isEmpty()) {
                    if (anotherElement.id.isEmpty() && anotherElement.classes.isEmpty()) {
                        return 1;
                    }
                    return anotherElement.getFullEdit();
                }

                return 1 + anotherElement.getFullEdit();
            }
        }
    }


    // Method take in a one line of DOM
    // parse the string
    // return a ArrayList of Elements in this DOM
    private static ArrayList<Element> makeLists(String dom) {
        String[] tags = dom.split(" ");
        ArrayList<Element> tagss = new ArrayList<Element>();

        for (String tag : tags) {
            Element element = new Element(tag);
            tagss.add(element);

        }
        return tagss;
    }

    // Method to calcualte distance between two DOMs
    private static int getDistance(ArrayList<Element> dom1, ArrayList<Element> dom2) {

        // Dynamic programming method

        // function f[i][j] to store the steps needed to change sub-DOM subDOM1(0 ~ i-1) to subDOM2(0 ~ j-1)
        // f[i][j] =             f[i-1][j-1]                                  if dom1(i) == dom2(j)
        //             f[i-1][j-1] + steps(change DOM1(i-1) to DOM2(j-1))     if dom1(i) != dom2(j)
        //             f[i-1][j] + steps(delete DOM1(i-1))                    if dom1(i) != dom2(j)
        //             f[i][j-1] + steps(add DOM2(j-1) to DOM1)               if dom1(i) != dom2(j)
        int[][] f = new int[dom1.size() + 1][dom2.size() + 1];

        // Initialization
        f[0][0] = 0;
        for (int i = 1; i < dom1.size()+1; i++) {
            f[i][0] = f[i-1][0] + 1;
        }
        for (int j = 1; j < dom2.size()+1; j++) {
            f[0][j] = f[0][j-1] + dom2.get(j-1).getFullEdit();
        }

        // Calculate function
        for (int i = 1; i < dom1.size() + 1; i++) {
            for (int j = 1; j < dom2.size() + 1; j++) {

                if (dom1.get(i-1).equals(dom2.get(j-1))) {
                    f[i][j] = f[i-1][j-1];
                } else {

                    // Case 1, change element in dom1 to element in dom2
                    int distance1 = f[i-1][j-1] + dom1.get(i-1).editTo(dom2.get(j-1));

                    // Case 2, delete element in dom1
                    int distance2 = f[i-1][j] + 1;

                    // Case 3, add whole element in dom2
                    int distance3 = f[i][j-1] + dom2.get(j-1).getFullEdit();

                    f[i][j] = Math.min(Math.min(distance1, distance2), distance3);
                }
            }
        }
        return f[dom1.size()][dom2.size()];
    }

    public static void main(String[] args) {

        // Only when the answer is wrong, program will output the two DOMs
        // Otherwise, program will only output the calcuated answer

        long t1 = System.currentTimeMillis();

        String[] testCase = testCaseString.split("\n");

        for (int i = 0; i < testCase.length; i += 3) {

            ArrayList<Element> dom1 = makeLists(testCase[i]);
            ArrayList<Element> dom2 = makeLists(testCase[i+1]);

            int answer = getDistance(dom1, dom2);

            if (answer != Integer.parseInt(testCase[i+2])) {
                System.out.println("--------------------");
                System.out.println(testCase[i]);
                System.out.println(testCase[i+1]);
                System.out.println("  Calculated   is " + answer);
                System.out.println("Correct Answer is " + testCase[i+2]);
                System.out.println("--------------------");
            } else {
                System.out.println("Calculated answer " + answer + " is correct");
            }
        }

        System.out.println("Time is : " + (System.currentTimeMillis() - t1) + " Millisecond");
    }
}
