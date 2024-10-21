using System;
using NAudio.Wave;

// Installed NAudio Nuget Package

// Simple program that plays an MP3 file. Player exits upon first encounter with an error.
// Code here is example code taken directly from the YT video linked in the project ReadMe.
namespace SimpleMusicPlayer
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Please provide the path to the MP3 file:");
            string mp3FilePath = Console.ReadLine(); 

            if (string.IsNullOrEmpty(mp3FilePath)) 
            {
                Console.WriteLine("No File path provided. Exiting program.");
                return;
            }

            try
            {
                using (var audioFile = new AudioFileReader(mp3FilePath))
                {
                    using (var outputDevice = new WaveOutEvent())
                    {
                        outputDevice.Init(audioFile);
                        outputDevice.Play();

                        Console.WriteLine("Playing... Press any key to stop.");
                        Console.ReadKey();

                        outputDevice.Stop();
                    }
                }

            }
            catch (Exception ex)
            {
                Console.WriteLine("An error occured: " + ex.Message);
            }
        }
    }
}
