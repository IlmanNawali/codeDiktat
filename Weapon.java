/**
 * 1972003 Ilman Nawali
 */
public interface Weapon {
    void attack(GameCharacter attacker, GameCharacter enemy);

    int getDamage();

}
