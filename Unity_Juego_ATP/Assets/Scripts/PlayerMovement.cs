using System.Collections;
using System.Collections.Generic;
using UnityEngine;

///////////////////////////////////////////////////////////////////
//               JUEGO PARA EL APLICATIVO MÓVIL ATP              //
//  SCRIPT:      PlayerMovement                                  //
//  DESCRIPCIÓN: Script que controla el movimiento del bus       //
//  AUTOR:       Chura Chambi, Pabel - Lipa Ochoa, José          //
//  FECHA:       08/07/2020                                      //
///////////////////////////////////////////////////////////////////

public class PlayerMovement : MonoBehaviour
{
    protected JoyButton joyButton;
    public Rigidbody2D playerRb;                            //Por referencia
    public float speed = 0.5f;
    public bool isGrounded = true;                          //Si está en el suelo
    void Start()
    {
        joyButton = FindObjectOfType<JoyButton>();
    }
    void Update()
    {
        playerRb.velocity = new Vector2(SimpleInput.GetAxis("Horizontal") * speed, playerRb.velocity.y);

        if (SimpleInput.GetAxis("Horizontal") == 0)             //Está quieto
        {
        }

        else if (SimpleInput.GetAxis("Horizontal") < 0)         //Izquierda
        {
            GetComponent<SpriteRenderer>().flipX = true;        //Por Componente, cambia flip
        }

        else if (SimpleInput.GetAxis("Horizontal") > 0)         //Derecha
        {
            GetComponent<SpriteRenderer>().flipX = false;       //Por Componente, cambia flip
        }

        if (joyButton.Pressed)                                  //Saltar
        {
            GetComponent<AudioSource>().Play();                 //Sonido de Bocina
        }
    }
}
