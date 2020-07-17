using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

///////////////////////////////////////////////////////////////////
//               JUEGO PARA EL APLICATIVO MÓVIL ATP              //
//  SCRIPT:      PlayerHealth                                    //
//  DESCRIPCIÓN: Script que controla la vida del player (bus)    //
//  AUTOR:       Chura Chambi, Pabel                             //
//  FECHA:       08/07/2020                                      //
///////////////////////////////////////////////////////////////////

public class PlayerHealth : MonoBehaviour
{
    int health = 3;
    public Image[] hearts;
    bool hasCooldown = false;
    public SceneChanger changeScene;

    void OnCollisionEnter2D (Collision2D collision)
    {
        if (collision.gameObject.CompareTag("Enemy"))
        {
            if (GetComponent<PlayerMovement>().isGrounded)  //Si está en el suelo
            {
                SubstractHealth();
            }
        }
    }

    void SubstractHealth()
    {
        if (!hasCooldown)
        {
            if (health > 0)
            {
                health--;
                hasCooldown = true;

                StartCoroutine(Cooldown());
            }
            if (health <= 0)                                //Revisar vida
            {
                changeScene.ChangeSceneTo("LoseScene");     //Cambio de Escena
            }

            EmptyHearts();                                  //Revisar corazones vacíos
        }
    }

    void EmptyHearts()
    {
        for (int i = 0; i < hearts.Length; i++)
        {
            if (health - 1 < i)                              //Indice empieza en 0
            {
                hearts[i].gameObject.SetActive(false);       //Desactivamos un corazon
            }
        }
    }
    IEnumerator Cooldown()
    {
        yield return new WaitForSeconds (0.5f);
        hasCooldown = false;

        StopCoroutine(Cooldown());
    }
}
