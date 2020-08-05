package com.example.day4detailone

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import androidx.core.view.marginStart
import androidx.core.view.marginTop

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addConstraintLayout()
    }

    private fun addConstraintLayout(){
        val con1 = ConstraintLayout(this).apply {
            id = R.id.mContainer
            layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT
                                                        ,ConstraintLayout.LayoutParams.MATCH_PARENT)
            background = getDrawable(R.color.colorPrimaryDark)
            setContentView(this)

        }
       ImageView(this).apply {
           id = R.id.mHeader
           layoutParams = ConstraintLayout.LayoutParams(120,90).apply {
               leftToLeft = R.id.mContainer
               topToTop = R.id.mContainer
               setMargins(dpTopx(10),dpTopx(10),0,0)

           }
           setImageResource(R.drawable.ic_launcher_background)
           scaleType = ImageView.ScaleType.CENTER_CROP
           con1.addView(this)

       }
        TextView(this).apply {
            id = R.id.mTitle
            layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
                    ,ConstraintLayout.LayoutParams.MATCH_CONSTRAINT).apply {
                leftToRight = R.id.mHeader
                rightToRight = R.id.mContainer
                topToTop = R.id.mHeader
                bottomToBottom = R.id.mHeader
            }
            setTextColor(getColor(R.color.colorWhite))
            text = "鸡肉需不需要焯水呢？很多人第一步都做错了，难怪做好后又老又腥"
            textSize = 20f
            con1.addView(this)

        }
        TextView(this).apply {

            layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
                    ,ConstraintLayout.LayoutParams.MATCH_CONSTRAINT).apply {
                leftToLeft = R.id.mHeader
                rightToRight = R.id.mTitle
                topToBottom = R.id.mHeader
                bottomToBottom = R.id.mContainer
                setMargins(0,dpTopx(10),0,0)
            }
            setTextColor(getColor(R.color.colorWhite))
            text = "鸡肉需不需要焯水呢？很多人第一步都做错了，难怪做好后又老又腥，如果就是给你们说起鸡肉，相信大家也是非常的熟悉，因为现在的鸡肉就是我们餐桌上经常就是能够见到的一种肉类，还有就是鸡肉吃上去也是非常的好吃，相信很多人，你们也是非常爱吃鸡肉的，还有你们大家应该知道肌肉如果做起来也是有着一定的难度"
            textSize = 20f
            con1.addView(this)

        }

    }
    private fun addRelativeLayout(){
        val r1 = RelativeLayout(this).apply {
            id = R.id.mContainer
            layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT)
            background = getDrawable(R.color.colorPrimaryDark)
            setContentView(this)
        }
        ImageView(this@MainActivity).apply {
            id = R.id.mHeader
            layoutParams = RelativeLayout.LayoutParams(dpTopx(120),dpTopx(90)).apply {
                setMargins(dpTopx(10),dpTopx(10),0,0)
            }
            setImageResource(R.drawable.ic_launcher_background)
            scaleType = ImageView.ScaleType.CENTER_CROP
            r1.addView(this)

        }
        TextView(this).apply {
            id = R.id.mTitle
            layoutParams = RelativeLayout.LayoutParams(0,0).apply {
                addRule(RelativeLayout.RIGHT_OF,R.id.mHeader)
                addRule(RelativeLayout.ALIGN_PARENT_END,R.id.mContainer)
                addRule(RelativeLayout.ALIGN_TOP,R.id.mHeader)
                addRule(RelativeLayout.ALIGN_BOTTOM,R.id.mHeader)
                marginStart = dpTopx(10)
            }
            setTextColor(getColor(R.color.colorWhite))
            text = "鸡肉需不需要焯水呢？很多人第一步都做错了，难怪做好后又老又腥"
            textSize = 20f
            r1.addView(this)
        }
        TextView(this).apply {
            layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,0).apply {
                addRule(RelativeLayout.BELOW,R.id.mHeader)
                addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,R.id.mContainer)
                addRule(RelativeLayout.ALIGN_START,R.id.mHeader)
                addRule(RelativeLayout.ALIGN_END,R.id.mTitle)
                setMargins(0,dpTopx(10),0,0)
            }
            setTextColor(getColor(R.color.colorWhite))
            text = "鸡肉需不需要焯水呢？很多人第一步都做错了，难怪做好后又老又腥，如果就是给你们说起鸡肉，相信大家也是非常的熟悉，因为现在的鸡肉就是我们餐桌上经常就是能够见到的一种肉类，还有就是鸡肉吃上去也是非常的好吃，相信很多人，你们也是非常爱吃鸡肉的，还有你们大家应该知道肌肉如果做起来也是有着一定的难度"
            textSize = 20f
            r1.addView(this)
        }

    }
    private fun addLinearLayoutKotlin() {
        val container = LinearLayout(this).apply {
            layoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            orientation = LinearLayout.VERTICAL
            background = getDrawable(R.color.colorAccent)
        }.also {
            setContentView(it)
        }

        //子控件
        LinearLayout(this).apply {
            layoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dpTopx(100))
            orientation = LinearLayout.HORIZONTAL
            background = getDrawable(R.color.colorPrimaryDark)
            container.addView(this)
        }.apply {
            ImageView(this@MainActivity).apply {
                layoutParams = LinearLayout.LayoutParams(dpTopx(120),
                        LinearLayout.LayoutParams.MATCH_PARENT)
                setImageResource(R.drawable.ic_launcher_background)
                scaleType = ImageView.ScaleType.CENTER_CROP
                addView(this)
            }
            TextView(this@MainActivity).apply {
                layoutParams = LinearLayout.LayoutParams(0,
                        LinearLayout.LayoutParams.MATCH_PARENT).apply {
                    weight = 1f
                    setMargins(dpTopx(10), dpTopx(10), dpTopx(10), dpTopx(10))
                }

                text = "鸡肉需不需要焯水呢？很多人第一步都做错了，难怪做好后又老又腥"
                setTextColor(getColor(R.color.colorWhite))
                addView(this)


            }
        }

        //第二个子控件
        TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT).apply {
                setMargins(dpTopx(10), dpTopx(10), dpTopx(10), dpTopx(10))
            }
            text = "鸡肉需不需要焯水呢？很多人第一步都做错了，难怪做好后又老又腥，如果就是给你们说起鸡肉，相信大家也是非常的熟悉，因为现在的鸡肉就是我们餐桌上经常就是能够见到的一种肉类，还有就是鸡肉吃上去也是非常的好吃，相信很多人，你们也是非常爱吃鸡肉的，还有你们大家应该知道肌肉如果做起来也是有着一定的难度，如果你们鸡肉处理不好的话，就会有着一股非常浓的腥味，甚至吃上去东西就是味道不好吃，今天我就想要跟你们说的鸡肉要不要焯水，相信很多人第一个步骤做错之后，所以做出来的鸡肉又老又腥。"
            setTextColor(getColor(R.color.colorWhite))
            textSize = 20f
            container.addView(this)


        }
    }

    private fun dpTopx(dp: Int): Int {
        return (resources.displayMetrics.density * dp).toInt()

    }

    private fun addLinearLayoutJava() {
        val linear1 = LinearLayout(this)

        linear1.layoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)

        linear1.orientation = LinearLayout.VERTICAL

        linear1.background = getDrawable(R.color.colorAccent)

        setContentView(linear1)
    }
}