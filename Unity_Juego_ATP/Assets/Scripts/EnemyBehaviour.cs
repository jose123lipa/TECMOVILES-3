using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

///////////////////////////////////////////////////////////////////
//               JUEGO PARA EL APLICATIVO MÓVIL ATP              //
//  SCRIPT:      EnemyBehaviour                                  //
//  DESCRIPCIÓN: Script que controla al enemigo                  //
//  AUTOR:       Lipa Ochoa, José - Ccuno Carlos, Paul           //
//  FECHA:       08/07/2020                                      //
///////////////////////////////////////////////////////////////////

public class EnemyBehaviour : MonoBehaviour
{
    Rigidbody2D enemyRb;
    SpriteRenderer enemySpriteRend;
    Animator enemyAnim;                                     //Componente de animación
    ParticleSystem collectableParticle;                     //Objeto partícula
    float timeBeforeChange;
    public float delay = 0.1f;
    public float speed = 0.1f;

    void Start()
    {
        enemyRb = GetComponent<Rigidbody2D>();                 //Accedemos al componente Rigidbody
        enemySpriteRend = GetComponent<SpriteRenderer>();      //Accedemos al componente SpriteRend
        enemyAnim = GetComponent<Animator>();                  //Accedemos al componente Animator
        collectableParticle = GameObject.Find("CollectableParticle").GetComponent<ParticleSystem>(); 

    }
   
    void Update()
    {
        enemyRb.velocity = Vector2.right * speed;               //Velocidad
    }

    void OnCollisionEnter2D (Collision2D collision)
    {
        if(collision.gameObject.tag == "Player")                //Colisión con player
        {
            GetComponent<AudioSource>().Play();                             //Sonido
            collectableParticle.transform.position = transform.position;    //Movemos a cada coleccionable
            collectableParticle.Play();                                     //Ejecuta particula
        }
    }
    public void DisableEnemy ()
    {
        gameObject.SetActive(false);                            //Desactivar objeto    
    }
}
