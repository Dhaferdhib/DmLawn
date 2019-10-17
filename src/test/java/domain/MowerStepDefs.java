package domain;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import enumeration.OrientationEnum;
import org.junit.Assert;

public class MowerStepDefs {
    private Mower mower;

    @Given("^a mower in (\\d+),(\\d+) facing (.*)$")
    public void a_mower_in_facing(int x, int y, OrientationEnum orientation) {
        mower = new Mower(x, y, orientation);
    }

    @When("^I move the mower$")
    public void i_move_the_mower() {
        mower.moveForward(100, 100);
    }

    @Then("^the mower should be in (\\d+),(\\d+) facing (.*)$")
    public void the_mower_should_be_in_facing(int x, int y, String orientation) {
        Position expectedPosition = new Position(x, y);
        OrientationEnum expectedOrientation = getOrientation(orientation);
        Assert.assertEquals("Mower position", expectedPosition, mower.getPosition());
        Assert.assertEquals("Mower orientation", expectedOrientation, mower.getOrientation());
    }

    @When("^I pivot the mower to the (.*)$")
    public void i_pivot_the_mower_to_the(String direction) {
        if (direction.equalsIgnoreCase("right")) {
            mower.turnRight();
        } else if (direction.equalsIgnoreCase("left")) {
            mower.turnLeft();
        }
    }


    private OrientationEnum getOrientation(String orientation) {
        return OrientationEnum.valueOf(orientation.toUpperCase());
    }

}
