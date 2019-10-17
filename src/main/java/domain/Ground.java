package domain;

import java.util.Set;

public class Ground {

    private int width;
    private int height;
    private Set<Mower> mowers;


    public Ground(int width, int height, Set<Mower> mowers) {
        this.width = width;
        this.height = height;
        this.mowers = mowers;
    }

    public void execute(){
        mowers.forEach(mower -> mower.executeActions(width, height));
    }

}
