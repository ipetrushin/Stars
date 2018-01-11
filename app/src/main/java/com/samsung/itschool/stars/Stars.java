package com.samsung.itschool.stars;

public class Stars {
    float[] radii;
    float[] angles;
    float[] velocities;
    float MAX_RADIUS = 500;
    float START_RADIUS;

    Stars(float startradius, int number, float min_velocity, float max_velocity) {
        // создаёт number случайных точек
        // внутри круга радиусом startradius
        // со случайными скоростями и углами
        START_RADIUS = startradius;
        radii = new float[number];
        angles = new float[number];
        velocities = new float[number];
        for (int i = 0; i < number; i++) {
            radii[i] = (float) Math.random() * startradius;
            angles[i] = (float) (Math.random() * 2 * Math.PI);
            velocities[i] = (float) (Math.random() * (max_velocity - min_velocity) + min_velocity);
        }

    }
    void step() {
        // двигает каждую "звезду" на шаг = velocity
        // если радиус вышел за MAX_RADIUS, генерирует новый случайный радиус
        for (int i = 0; i < radii.length; i++) {
            radii[i] += velocities[i];
            if (radii[i] > MAX_RADIUS) {
                radii[i] = (float) Math.random() * START_RADIUS;
            }
        }
    }
}
