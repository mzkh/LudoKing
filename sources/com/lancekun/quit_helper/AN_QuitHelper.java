package com.lancekun.quit_helper;

public class AN_QuitHelper {
    private static AN_QuitHelper m_insatance;

    public static AN_QuitHelper Instance() {
        if (m_insatance == null) {
            m_insatance = new AN_QuitHelper();
        }
        return m_insatance;
    }

    private void AN_Exit() {
        System.exit(0);
    }
}
