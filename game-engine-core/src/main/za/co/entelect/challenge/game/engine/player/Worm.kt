package za.co.entelect.challenge.game.engine.player

import za.co.entelect.challenge.game.engine.map.Point
import za.co.entelect.challenge.game.engine.map.WormsMap

open class Worm(var health: Int,
                var weapon: Weapon,
                val diggingRange: Int,
                val movementRange: Int) {

    constructor(health: Int, position: Point, weapon: Weapon, diggingRange: Int = 1, movementRange: Int = 1) : this(health, weapon, diggingRange, movementRange) {
        this.position = position
        this.previousPosition = position
    }

    var id = ++wormsCount
    var roundMoved: Int = -1
    var roundHit: Int = -1

    lateinit var position: Point
        private set
    lateinit var previousPosition: Point
        private set

    lateinit var player: WormsPlayer

    val dead: Boolean
        get() = health <= 0

    /**
     * Set position and previous position to the same value
     */
    fun initPositions(position: Point) {
        this.position = position
        this.previousPosition = position
    }

    /**
     * Apply movement logic
     * - Clear occupier of current map cell
     * - Set occupier of target map cell
     * - Update previous position
     * - Update current position
     * - Set last movement round
     * - Pick up powerups
     */
    fun moveTo(gameMap: WormsMap, target: Point) {
        val originCell = gameMap[position]
        val targetCell = gameMap[target]

        originCell.occupier = null

        previousPosition = position
        roundMoved = gameMap.currentRound
        position = target

        targetCell.occupier = this

        /**
         * Right now we only have single use powerups. If that changes,
         * we can move the clearing logic into the powerup `applyTo` method
         */
        targetCell.powerup?.applyTo(this)
        targetCell.powerup = null
    }


    fun takeDamage(damage: Int, round: Int) {
        health -= damage
        roundHit = round
    }

    companion object {
        private var wormsCount = 0
    }

}