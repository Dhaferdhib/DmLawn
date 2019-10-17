package domain;

import enumeration.ActionEnum;
import enumeration.OrientationEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MowerTest {

    private Mower mower;



    @Test
    public void shouldReturnCorrectOrientationForOneOperation(){
        mower = new Mower(0,0, OrientationEnum.NORTH, Arrays.asList(ActionEnum.LEFT));
        //when
        mower.executeActions(5,5);

        Assert.assertEquals(OrientationEnum.WEST, mower.getOrientation());
    }

    @Test
    public void shouldReturnCorrectOrientation(){
        mower = new Mower(0,0, OrientationEnum.NORTH, Arrays.asList(ActionEnum.RIGHT,ActionEnum.LEFT));
        //when
        mower.executeActions(5,5);

        Assert.assertEquals(OrientationEnum.NORTH, mower.getOrientation());
    }

    @Test
    public void shouldReturnCorrectOrientationForDoubleOperations(){
        mower = new Mower(0,0, OrientationEnum.NORTH, Arrays.asList(ActionEnum.LEFT,ActionEnum.LEFT));
        //when
        mower.executeActions(5,5);

        Assert.assertEquals(OrientationEnum.SOUTH, mower.getOrientation());
    }


    @Test
    public void shouldReturnCorrectOrientationAtRight(){
        mower = new Mower(0,0, OrientationEnum.NORTH, Arrays.asList(ActionEnum.RIGHT));
        //when
        mower.executeActions(5,5);

        Assert.assertEquals(OrientationEnum.EAST, mower.getOrientation());
    }

    @Test
    public void shouldReturnCorrectLocation(){
        mower = new Mower(0,1, OrientationEnum.NORTH, Arrays.asList(ActionEnum.LEFT,ActionEnum.FORWARD));
        //when
        mower.executeActions(5,5);

        Assert.assertEquals(OrientationEnum.WEST, mower.getOrientation());
        Assert.assertEquals("(0, 1, W)", mower.getLocation());
    }

}
