/**
 * 1972003 Ilman Nawali
 */
public class Sword extends Item implements Weapon{

    public Sword(){
        setName("Sword");
    }


    @Override
    public void attack(GameCharacter attacker, GameCharacter enemy) {
        if (((Monster)enemy).isFlyingUnit()){
            System.out.println("Enemy out of range");
            enemy.attackEnemy(attacker);
        }
        else{
            int nilaiDamage= getDamage() * 2;
            enemy.setCurrentHealth(enemy.getCurrentHealth()-nilaiDamage);
            System.out.println("Hero do "+nilaiDamage+" damage to monster");
        }
    }

    @Override
    public int getDamage() {
        return 9;
    }

    public String toString(){
        return String.format("%-10s%-10s",getName(),getDamage());
    }
}
