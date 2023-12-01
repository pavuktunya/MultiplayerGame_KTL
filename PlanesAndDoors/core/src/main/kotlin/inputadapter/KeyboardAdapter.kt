package inputadapter;

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.math.Vector2
import ktx.app.KtxInputAdapter

class KeyboardAdapter:KtxInputAdapter {
    private var leftPressed:Boolean=false;
    private var rightPressed:Boolean=false;
    private var upPressed:Boolean=false;
    private var downPressed:Boolean=false;

    private var direction = Vector2()
    public var mousePosition = Vector2()
        set(value){
            field=value
        }
        get()=field

    override fun keyDown(keycode: Int): Boolean {
        if(keycode==Input.Keys.A) leftPressed=true
        if(keycode==Input.Keys.D) rightPressed=true
        if(keycode==Input.Keys.W) upPressed=true
        if(keycode==Input.Keys.S) downPressed=true
        return false
    }

    override fun keyUp(keycode: Int): Boolean {
        if(keycode==Input.Keys.A) leftPressed=false
        if(keycode==Input.Keys.D) rightPressed=false
        if(keycode==Input.Keys.W) upPressed=false
        if(keycode==Input.Keys.S) downPressed=false
        return false
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        mousePosition.set(screenX.toFloat(), Gdx.graphics.height.toFloat()-screenY.toFloat())
        return super.mouseMoved(screenX, screenY)
    }

    fun getDirection():Vector2{
        direction.set(0f,0f)

        if(leftPressed) direction.add(-5f,0f)
        if(rightPressed) direction.add(5f,0f)
        if(upPressed) direction.add(0f,5f)
        if(downPressed) direction.add(0f,-5f)

        return direction
    }
}
