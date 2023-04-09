public class test {
   
  
        
       
        else{
           
        }
    }


nombreDesClasses = ((nombreDesClass)cardPanels.getComponents()[0]).getNombreDesClasses();
currentClass++;
hasParametres = ((Methodes)cardPanels.getComponents()[3]).getHasParametres();
if(hasParametres == 1){//if the methode has parametres we go to parameteres page
    //set the name of the current methode 
    myFooter.nextButton.setText("Back to Methodes");
    ((ParametresDesMethodes)cardPanels.getComponents()[4]).setNomDeCurrentMethode(((Methodes)cardPanels.getComponents()[3]).getNomDeCurrentMethode());
    ((CardLayout)cardPanels.getLayout()).show(cardPanels, "5");
    currentPage++;
}else if (hasParametres == 0){
    if(currentClass < nombreDesClasses){
        nomDeCurrentClass =  ((LesNomsDesClasses)cardPanels.getComponents()[1]).getLesNomDesClass().get(currentClass);
        ((Attributes)cardPanels.getComponents()[2]).getTitreDePanel().setText("Attributes De Class : "+nomDeCurrentClass);
        ((CardLayout)cardPanels.getLayout()).show(cardPanels, "3");
        currentPage--;
    }else{
        //after we end with all the classes, we need to go back to the first page and reset the count of the
        currentClass = 0;
        ((CardLayout)cardPanels.getLayout()).show(cardPanels, "end");
        currentPage = -1;
        myFooter.nextButton.setText("Finish");
    }
}else{
    ((Methodes)cardPanels.getComponents()[3]).getErrorsField().setText("Error: hasParametres is not 0 or 1");
}
