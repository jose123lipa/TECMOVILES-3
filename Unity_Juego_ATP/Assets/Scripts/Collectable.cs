using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

///////////////////////////////////////////////////////////////////
//               JUEGO PARA EL APLICATIVO MÓVIL ATP              //
//  SCRIPT:      Collectable                                     //
//  DESCRIPCIÓN: Script que controla a un collectable (moneda)   //
//  AUTOR:       Chura Chambi, Pabel                             //
//  FECHA:       08/07/2020                                      //
///////////////////////////////////////////////////////////////////

public class Collectable : MonoBehaviour
{
    public static int collectableQuantity = 0;              //Acumulador de puntos
    Text collectableText;
    ParticleSystem collectableParticle;                     //Objeto partícula
    AudioSource collectableAudio;                           //Objeto audio
    Animator coinAnim;                                      //Componente de animación

    void Start()
    {
        collectableQuantity = 0;                            //Reinicia el contador
        collectableText = GameObject.Find("CollectableQuantityText").GetComponent<Text>();
        collectableParticle = GameObject.Find("CollectableParticle").GetComponent<ParticleSystem>(); 
        collectableAudio = GetComponentInParent<AudioSource>();            //Componente audio
    }
    void Update()
    {

    }

    void OnTriggerEnter2D (Collider2D col)
    {
        if (col.tag == "Player")                                            //Collider accede directamente al tag
        {
            collectableParticle.transform.position = transform.position;    //Movemos a cada coleccionable
            collectableParticle.Play();                                     //Ejecuta particula

            collectableAudio.Play();
            
            gameObject.SetActive(false);                                    //Desactivar objeto
            collectableQuantity++;                                          //Agregar un diamante
            collectableText.text = collectableQuantity.ToString();
        }
    }
}
