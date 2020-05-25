package controller;

import viewing.Rahmen;

public class Controller {

    private Rahmen R1;
    private StringBuilder S1;

    public Controller() {}

    public void createRahmen(){
        R1 = new Rahmen(this);
    }

    public void createNewStringBuilder(){
        S1 = new StringBuilder(R1.getStringBuilderEingabe());
        aktualisiereAnzeigeSB();
    }
    public void useCharAt(String s){
        int i = -1;
        String returnMe;
        try{ i = Integer.parseInt(s);}catch (Exception e) { R1.setStringBuilderEingabe("Error");}
        try{
             returnMe = i !=-1 ? String.valueOf(S1.charAt(i)) : "Parsing Error";
             R1.setStringBuilderEingabe(returnMe);

        }catch(NullPointerException E){R1.setStringBuilderEingabe("not Initialized yet. Create a new StringBuilder first");
        }
        catch(StringIndexOutOfBoundsException F){R1.setStringBuilderEingabe("Out of Bounds");}
    }
    public void useIndexOf(String s, String t){
        int i1 = -1;
        try{i1 = Integer.parseInt(t);} catch(Exception E){}
        try {
            int y = i1 != -1 ? S1.indexOf(s, i1) : S1.indexOf(s);
            R1.setStringBuilderEingabe(String.valueOf(y));
        }catch (NullPointerException E){R1.setStringBuilderEingabe("not Initialized yet. Create a new StringBuilder first");}


    }
    public void useLength(){
        try{
            R1.setStringBuilderEingabe(String.valueOf(S1.length()));
        }catch(NullPointerException E){R1.setStringBuilderEingabe("not Initialized yet. Create a new StringBuilder first");}
    }
    public void useSubstring(String s, String t){
        int i1 = -1;
        int i2 = -1;
        try{i1 = Integer.parseInt(s);}catch (Exception E){}
        try{i2 = Integer.parseInt(t);}catch (Exception E){}

        if(i1 != -1){
            if (i2 != -1) {
                try {
                    R1.setStringBuilderEingabe(S1.substring(i1, i2));
                }catch(StringIndexOutOfBoundsException E){R1.setBeschreibungStringBuilderEingabe("Out of Bounds");}
                catch(NullPointerException E){R1.setStringBuilderEingabe("not Initialized yet. Create a new StringBuilder first");
                }
            } else {
                try {
                    R1.setBeschreibungStringBuilderEingabe(S1.substring(i1));
                }catch(StringIndexOutOfBoundsException E){R1.setBeschreibungStringBuilderEingabe("Out of Bounds");}
                catch(NullPointerException E){R1.setStringBuilderEingabe("not Initialized yet. Create a new StringBuilder first");
                }
            }
        }else R1.setStringBuilderEingabe("A Number is needed");
    }
    public void useAppend(){
        try {
            S1.append(R1.getStringBuilderEingabe());
            aktualisiereAnzeigeSB();
        }catch(NullPointerException E){R1.setStringBuilderEingabe("not Initialized yet. Create a new StringBuilder first");}
    }
    public void useInsert(String s) {
        int i = -1;

        try{ i = Integer.parseInt(s);
        }catch (Exception E){}

        try {
            S1.insert(i, R1.getStringBuilderEingabe());
            aktualisiereAnzeigeSB();
        }catch (NullPointerException E){R1.setStringBuilderEingabe("not Initialized yet. Create a new StringBuilder first");}
        catch (StringIndexOutOfBoundsException F){R1.setStringBuilderEingabe("Out of Bounds");}

    }
    public void useDelete(String s, String t){
        int i = -1, j = -1;
        try {
            i = Integer.parseInt(s);
            j = Integer.parseInt(t);
        }catch (Exception E){}

        if (i != -1 & j != -1){
            try {
                S1.delete(i, j);
                aktualisiereAnzeigeSB();
            }catch (StringIndexOutOfBoundsException E) {
                R1.setStringBuilderEingabe("Out of Bounds");
            }catch (NullPointerException E){R1.setStringBuilderEingabe("not Initialized yet. Create a new StringBuilder first");}
            }else R1.setStringBuilderEingabe("Please insert Numbers");
    };
    public void useDeleteCharAt(String s){
        int i = -1;
        try{i = Integer.parseInt(s);}catch (Exception E){};
        try{
            S1.deleteCharAt(i);
            aktualisiereAnzeigeSB();
        } catch (NullPointerException E){R1.setStringBuilderEingabe("not Initialized yet. Create a new StringBuilder first");}
          catch (StringIndexOutOfBoundsException E){R1.setStringBuilderEingabe("Out of Bounds");}

    };
    public void useReverse(){
        try {
            S1.reverse();
            aktualisiereAnzeigeSB();
        }catch (NullPointerException E){R1.setStringBuilderEingabe("not Initialized yet. Create a new StringBuilder first");}
    };
    private void aktualisiereAnzeigeSB(){
        R1.setStringBuilderAusgabe(S1.toString());
        R1.setStringBuilderEingabe("");
    }



}
