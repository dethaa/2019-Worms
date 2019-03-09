package za.co.entelect.challenge.game.contracts.bootstrapper;

import za.co.entelect.challenge.game.contracts.game.GameEngine;
import za.co.entelect.challenge.game.contracts.game.GameMapGenerator;
import za.co.entelect.challenge.game.contracts.game.GameRoundProcessor;
import za.co.entelect.challenge.game.contracts.renderer.GameMapRenderer;
import za.co.entelect.challenge.game.contracts.renderer.RendererType;

/**
 * Acts as a builder for game engine related classes.
 *
 * Each time the getters are called:
 *  * They should return new instances of the relevant classes
 *  * These instances should use the last seed and config path that was set.
 *
 * This interface should serve as the main connection point between the game runner and the game engine
 * and should be the only class dynamically class-loaded
 */
public interface GameEngineBootstrapper {

    void setSeed(long seed);

    void setConfigPath(String path);

    GameEngine getGameEngine();

    GameMapGenerator getMapGenerator();

    GameMapRenderer getRenderer(RendererType rendererType);

    GameRoundProcessor getRoundProcessor();
}
