import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestWarGames {

    PresidentialSecretary presidentialSecretary;
    General general1, general2;
    Soldier soldier1, soldier2, soldier3, soldier4;
    AttackHandler attackHandler1, attackHandler2;
    RecruitmentCenter recruitmentCenter;
    ManeuversCenter maneuversCenter;
    MoneyTransfer moneyTransfer1, moneyTransfer2;



    @BeforeEach
    void setup(){
        presidentialSecretary = new PresidentialSecretary("Report.txt");

        general1 = new General("general_1", 1000);
        general2 = new General("general_2", 0);

        soldier1 = new Soldier(1);
        soldier2 = new Soldier(2);
        soldier3 = new Soldier(3);
        soldier4 = new Soldier(4);

        general1.army.add(soldier1);
        general1.army.add(soldier2);
        general2.army.add(soldier3);
        general2.army.add(soldier4);


        attackHandler1 = new AttackHandler(general1, presidentialSecretary);
        attackHandler2 = new AttackHandler(general2, presidentialSecretary);

        recruitmentCenter = new RecruitmentCenter(presidentialSecretary);

        maneuversCenter = new ManeuversCenter(presidentialSecretary);

        moneyTransfer1 = new MoneyTransfer(0.1, general1);
        moneyTransfer2 = new MoneyTransfer(0.1, general1);
    }

    //Soldier tests

    @Test
    void testSoldierGetGrade(){
        assertEquals(soldier1.getGrade(), "Szeregowy");
    }
    @Test
    void testSoldierGetExperience(){
        assertEquals(soldier1.getExperience(), 1);
    }
    @Test
    void testSoldierGetValue(){
        assertEquals(soldier1.getValue(), 1);
    }
    @Test
    void testSoldierGetPower(){
        assertEquals(soldier1.getPower(),1);
    }
    @Test
    void testSoldierExperienceGain(){
        soldier1.experienceGain();
        assertEquals(soldier1.getExperience(),2);
    }
    @Test
    void testSoldierExperienceLoss(){
        soldier1.experienceGain();
        soldier1.experienceLoss();

        assertEquals(soldier1.getExperience(),1);
    }

    //General tests

    @Test
    void testGeneralGetName(){
        assertEquals(general1.getName(), "general_1");
    }
    @Test
    void testGeneralGetMoney(){
        assertEquals(general1.getMoney(), 1000);
    }
    @Test
    void testGeneralAddMoney(){
        general1.addMoney(1);
        assertEquals(general1.getMoney(), 1001);
    }
    @Test
    void testGeneralSubtractMoney(){
        general1.subtractMoney(1);
        assertEquals(general1.getMoney(),999);
    }
    @Test
    void testGeneralGetArmyPower(){
        assertEquals(general1.getArmyPower(),3);
    }
    @Test
    void testGeneralSoldierBurial(){
        assertEquals(general1.army.size(), 2);
    }

    //ManeuversCenter tests

    @Test
    void testManouversCenterStandardCanExecute(){
        assertTrue(maneuversCenter.canExecute(general1));
    }
    @Test
    void testManouversCenterNonStandardCanExecute(){
        assertTrue(maneuversCenter.canExecute(general1, 0.9));
    }
    @Test
    void testManouversCenterNotStandardExecute(){
        Integer armyPowerBefore=general1.getArmyPower();
        maneuversCenter.execute(general1,1.0);

        //assertEquals(general1.getArmyPower(),armyPowerBefore);
        assertTrue(general1.getMoney()<999);
    }

    //MoneyTransfer tests

    @Test
    void testMoneyTransferCanExecute(){
        assertTrue(moneyTransfer1.canExecute(general2));
    }

    @Test
    void testMoneyTransferExecute(){
        moneyTransfer1.execute(general2);
        assertEquals(general1.getMoney(),900);
        assertEquals(general2.getMoney(), 100);
    }

    //RecruitmentCenter tests

    @Test
    void testRecruitmentCenterCanExecute(){
        assertTrue(recruitmentCenter.canExecute(general1, 10, 2));
        assertFalse(recruitmentCenter.canExecute(general1, 1000, 2));
    }

    @Test
    void testRecruitmentCenterExecute(){
        recruitmentCenter.execute(general1,10,1);
        assertEquals(general1.getArmyPower(),13);
    }

    //AttackHandler tests

    @Test
    void testAttackHandlerBattleLoss(){
        attackHandler1.battleLoss(general1);
        assertTrue(general1.getArmyPower()<3);
        assertTrue(general1.getMoney()<1000);
    }
    @Test
    void testAttackHandlerBattleWin() {
        Integer tempArmyPower1 = general1.getArmyPower();
        attackHandler1.battleWin(general2);

        assertEquals(2, (Integer) soldier3.getExperience());
        assertEquals(2, (Integer) soldier4.getExperience());
    }

    @Test
    void testAttackHandlerIfGeneral2Wins() {
            Integer tempArmyPower1 = general1.getArmyPower();
            attackHandler1.execute(general2);

            assertTrue(general1.getArmyPower().equals(2));
            assertEquals(2, (int) soldier3.getExperience());
            assertTrue(general2.getMoney() > 0);
            assertEquals(2, (Integer) soldier3.getExperience());
            assertEquals(2, (Integer) soldier4.getExperience());
    }
    @Test
    void testAttackHandlerIfDraw() {
        Soldier soldier5 = new Soldier(4);
        general1.army.add(soldier5);

        attackHandler1.execute(general2);

        assertTrue(general1.getArmyPower()<7);
        assertTrue(general2.getArmyPower()<7);
    }







}
