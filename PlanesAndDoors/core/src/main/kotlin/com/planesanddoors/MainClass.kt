package com.planesanddoors

import actors.Player
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.Texture.TextureFilter.Linear
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import inputadapter.KeyboardAdapter
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.app.clearScreen
import ktx.assets.disposeSafely
import ktx.assets.toInternalFile
import ktx.async.KtxAsync
import ktx.graphics.use

class MainClass : KtxGame<KtxScreen>() {
    private lateinit var firstScreen:FirstScreen
    override fun create() {
        KtxAsync.initiate()

        firstScreen=FirstScreen()
        addScreen(firstScreen)
        setScreen<FirstScreen>()

        Gdx.input.inputProcessor=firstScreen.keyboardAdapter
    }
}

class FirstScreen : KtxScreen {
    private val batch = SpriteBatch()
    private var player: Player=Player(Vector2(0f,0f))
    public var keyboardAdapter=KeyboardAdapter()

    private val players: MutableList<Player> = mutableListOf(Player(0f,100f), Player(40f,20f), Player(15f, 88f))

    override fun render(delta: Float) {
        player.moveTo(keyboardAdapter.getDirection())
        player.rotateTo(keyboardAdapter.mousePosition)
        players.forEach { it.rotateTo(player.getPosition()) }

        clearScreen(red = 0.2f, green = 0.4f, blue = 0.7f)

        batch.use{
            player.render(batch)
            players.forEach { it.render(batch) }
        }
    }

    override fun dispose() {
        batch.disposeSafely()
        player.dispose()
    }
}
