import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.photonvision.PhotonCamera;
import org.photonvision.simulation.PhotonCameraSim;

import com.revrobotics.sim.SparkMaxSim;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.math.system.plant.DCMotor;

class PhoenixTest {
    static SparkMax sparkMax;
    static SparkMaxSim sparkMaxSim;

    @BeforeAll
    static void setup() {
        assert HAL.initialize(500, 0);
        sparkMax = new SparkMax(1, MotorType.kBrushless);
        sparkMaxSim = new SparkMaxSim(sparkMax, DCMotor.getNEO(1));
    }

    @Test
    void testsparkMax() {
        sparkMax.set(0.5);
        sparkMaxSim.setAppliedOutput(0.5);
        sparkMaxSim.iterate(0, 12, 0.02);
        assertEquals(0.5, sparkMax.get(), 0.01);
    }
}
