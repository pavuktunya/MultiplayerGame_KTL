package actors

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Vector2
import ktx.assets.disposeSafely
import ktx.assets.toInternalFile
import ktx.graphics.use

class Player(
    private val position: Vector2=Vector2(),
    private val texture:Texture = Texture(
        "graphics/monster/rat/rat_idle.png".toInternalFile(),
        true
    ).apply {
        setFilter(
        Texture.TextureFilter.Linear,
        Texture.TextureFilter.Linear
    )
    },
    private val textureRegion:TextureRegion=TextureRegion(texture)
) {
    constructor(x:Float, y:Float):this(
        Vector2(x,y),

        Texture(
        "graphics/hero/fantazy_warrior/fantazy_warrior_idle.png".toInternalFile(),
        true
    ).apply {
        setFilter(
            Texture.TextureFilter.Linear,
            Texture.TextureFilter.Linear
        )
    }
    )

    private val angle:Vector2=Vector2()

    private val size:Float=64f
    private val halfSize:Float=size/2

    fun render (batch:Batch){
        batch.draw(
            textureRegion,
            position.x,
            position.y,
            halfSize, //originX - point rotate
            halfSize, //originY - point rotate
            size, //width
            size,
            1f,
            1f,
            angle.angleDeg()-90 //rotation
        )
    }

    fun getPosition()=position
    fun moveTo(direction: Vector2){
        position.add(direction)
    }

    fun rotateTo(mousePosition: Vector2){
        angle.set(mousePosition).sub(position.x+halfSize, position.y+halfSize) //minus Vector
        //сдвигаем координаты центра поворота
    }

    fun dispose(){
        texture.disposeSafely()
    }
}
