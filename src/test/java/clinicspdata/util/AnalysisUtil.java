package clinicspdata.util;

import clinicapp.entity.Analysis;

/**
 * @author Oleg Romanenchuk
 */
public class AnalysisUtil {
    public static Analysis create() {
        Analysis analysis = new Analysis();
        analysis.setId(1);
        analysis.setDate("15.07.2015");
        analysis.setNotes("Blood analysis");
        return analysis;
    }

}
