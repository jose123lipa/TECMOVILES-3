using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

///////////////////////////////////////////////////////////////////
//               JUEGO PARA EL APLICATIVO MÓVIL ATP              //
//  SCRIPT:      BusStationBehaviour                             //
//  DESCRIPCIÓN: Script que controla el comportamiento del bus   //
//  AUTOR:       Chura Chambi, Pabel - Ccuno Carlos, Paul        //
//  FECHA:       08/07/2020                                      //
///////////////////////////////////////////////////////////////////

public class BusStationBehaviour : MonoBehaviour
{
    SpriteRenderer busSpriteRend;
    Animator busAnim;                                           //Componente de animación
    ParticleSystem BuscollectableParticle;                      //Objeto partícula
    float timeBeforeChange;
    public float delay = 0.05f;
    public float speed = 0.1f;

    void Start()
    {
        busSpriteRend = GetComponent<SpriteRenderer>();         //Accedemos al componente SpriteRend
        busAnim = GetComponent<Animator>();                     //Accedemos al componente Animator
        BuscollectableParticle = GameObject.Find("BusStationParticle").GetComponent<ParticleSystem>(); 

    }
   
    void Update()
    {
        if (timeBeforeChange < Time.time)                       //Time.time ; hora de inicio de app
        {
            speed *= -1;                                        //Cambiar dirección
            timeBeforeChange = Time.time + delay;
        }
    }

    void OnTriggerEnter2D (Collider2D collision)
    {
        if(collision.tag == "Player")                           //Colisión con player
        {

            GetComponent<AudioSource>().Play();                                 //Sonido de muerte
            BuscollectableParticle.transform.position = transform.position;     //Movemos a cada coleccionable
            BuscollectableParticle.Play();                                      //Ejecuta particula
            //gameObject.SetActive(false);                      //Desactivar objeto
        }
    }
    public void DisableEnemy ()
    {
        gameObject.SetActive(false);                            //Desactivar objeto
        //Destroy(gameObject);                                  //Desaparece de la jerarquia        
    }   
}
