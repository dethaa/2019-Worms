package za.co.entelect.challenge.game.engine.command.feedback

import za.co.entelect.challenge.game.engine.command.CommandStrings
import za.co.entelect.challenge.game.engine.player.Worm
import za.co.entelect.challenge.game.engine.renderer.printables.VisualizerEvent

class DoNothingCommandFeedback(command: String,
                               worm: Worm,
                               score: Int)
    : CommandFeedback(command = command, score = score, playerId = worm.player.id, success = true) {
    override val message = "$worm successfully did nothing"
    override val visualizerEvent = VisualizerEvent(CommandStrings.NOTHING.string, null, worm, null, null, null)
}
