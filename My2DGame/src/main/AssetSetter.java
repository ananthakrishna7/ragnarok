package main;
import entity.NPC_OldMan;
import monster.MON_GreeenSlime;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Potion;

public class AssetSetter {
    
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;

    }

    public void setObject() {

        int i = 0;

        gp.obj[i] = new OBJ_Key(gp);
        gp.obj[i].worldX = gp.tileSize * 38;
        gp.obj[i].worldY = gp.tileSize * 8;

        i++;

        gp.obj[i] = new OBJ_Potion(gp);
        gp.obj[i].worldX = gp.tileSize * 30;
        gp.obj[i].worldY = gp.tileSize * 36;

        i++;

        gp.obj[i] = new OBJ_Door();
        gp.obj[i].worldX = gp.tileSize * 14 ;
        gp.obj[i].worldY = gp.tileSize * 27;

        i++;

        gp.obj[i] = new OBJ_Door();
        gp.obj[i].worldX = gp.tileSize * 10 ;
        gp.obj[i].worldY = gp.tileSize * 12;
        




    }

    public void setNPC() {

        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize*21;
        gp.npc[0].worldY = gp.tileSize*21;
        
    }

    public void setMonster() {

        int i = 0;
        gp.monster[i] = new MON_GreeenSlime(gp);
        gp.monster[i].worldX = gp.tileSize*23;
        gp.monster[i].worldY = gp.tileSize*36;

        i++;

        gp.monster[i] = new MON_GreeenSlime(gp);
        gp.monster[i].worldX = gp.tileSize*23;
        gp.monster[i].worldY = gp.tileSize*37;

        i++;

        gp.monster[i] = new MON_GreeenSlime(gp);
        gp.monster[i].worldX = gp.tileSize*24;
        gp.monster[i].worldY = gp.tileSize*37;

        i++;


        gp.monster[i] = new MON_GreeenSlime(gp);
        gp.monster[i].worldX = gp.tileSize*34;
        gp.monster[i].worldY = gp.tileSize*42;

        i++;


        gp.monster[i] = new MON_GreeenSlime(gp);
        gp.monster[i].worldX = gp.tileSize*38;
        gp.monster[i].worldY = gp.tileSize*42;
        
        i++;

        gp.monster[i] = new MON_GreeenSlime(gp);
        gp.monster[i].worldX = gp.tileSize*38;
        gp.monster[i].worldY = gp.tileSize*10;
        
        i++;

        gp.monster[i] = new MON_GreeenSlime(gp);
        gp.monster[i].worldX = gp.tileSize*39;
        gp.monster[i].worldY = gp.tileSize*10;
        
        i++;

        gp.monster[i] = new MON_GreeenSlime(gp);
        gp.monster[i].worldX = gp.tileSize*38;
        gp.monster[i].worldY = gp.tileSize*9;
        
        i++;

        gp.monster[i] = new MON_GreeenSlime(gp);
        gp.monster[i].worldX = gp.tileSize*38;
        gp.monster[i].worldY = gp.tileSize*8;
        
        i++;

        gp.monster[i] = new MON_GreeenSlime(gp);
        gp.monster[i].worldX = gp.tileSize*38;
        gp.monster[i].worldY = gp.tileSize*10;
        
        i++;
        

        gp.monster[i] = new MON_GreeenSlime(gp);
        gp.monster[i].worldX = gp.tileSize*33;
        gp.monster[i].worldY = gp.tileSize*11;
        
        i++;

        gp.monster[i] = new MON_GreeenSlime(gp);
        gp.monster[i].worldX = gp.tileSize*34;
        gp.monster[i].worldY = gp.tileSize*11;
        
        i++;

        gp.monster[i] = new MON_GreeenSlime(gp);
        gp.monster[i].worldX = gp.tileSize*34;
        gp.monster[i].worldY = gp.tileSize*12;
        
        i++;

        gp.monster[i] = new MON_GreeenSlime(gp);
        gp.monster[i].worldX = gp.tileSize*30;
        gp.monster[i].worldY = gp.tileSize*12;
        
        i++;

        gp.monster[i] = new MON_GreeenSlime(gp);
        gp.monster[i].worldX = gp.tileSize*40;
        gp.monster[i].worldY = gp.tileSize*32;
    }

}
